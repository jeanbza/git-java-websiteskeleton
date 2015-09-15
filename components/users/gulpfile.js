'use strict';

// Gulp Dependencies
var gulp = require('gulp');
var sass = require('gulp-sass');
var concat = require('gulp-concat');
var replace = require('gulp-replace');
var karma = require('gulp-karma');

var browserify = require('browserify');
var source = require('vinyl-source-stream');


// Other Dependencies
var yargs = require('yargs').argv;

// Environment Setup
var ENVS = require('./environment');
var env = ENVS.dev;
var passedArg = 'dev';
var buildDir = "./src/main/resources/META-INF/resources";

/* SCSS*/
gulp.task('scss', function () {
    gulp.src('./src/main/scss/**/*.scss')
        .pipe(sass().on('error', function (err) {
            console.error(err);
        }))
        .pipe(concat('app.css'))
        .pipe(gulp.dest(buildDir + '/css/'));
});

/* JavaScript */
gulp.task('browserify:js', ['config'], function () {
    return browserify('./src/main/javascript/app.js').bundle()
        // vinyl-source-stream makes the bundle compatible with gulp
        .pipe(source('app.js'))
        .pipe(gulp.dest(buildDir + '/js/'));
});
/* CoffeeScript */
gulp.task('browserify:coffee', function () {
    return browserify('./src/main/coffeescript/app.coffee').transform('coffeeify').bundle()
        // vinyl-source-stream makes the bundle compatible with gulp
        .pipe(source('app.coffee.js'))
        .pipe(gulp.dest(buildDir + '/js/'));
});
gulp.task('browserify', ['browserify:js', 'browserify:coffee']);

// Vendor node components with artifacts
gulp.task('vendor:javascript', function () {
    gulp.src([
        './node_modules/jquery/dist/jquery.min.js',
        './node_modules/bootstrap/dist/js/bootstrap.min.js'
    ]).pipe(concat('vendor.js'))
        .pipe(gulp.dest(buildDir + '/js/'))
});
gulp.task('vendor:styles', function () {
    gulp.src([
        './node_modules/bootstrap/dist/css/bootstrap.min.css',
        './node_modules/bootstrap/dist/css/bootstrap-theme.min.css'
    ]).pipe(concat('vendor.css'))
        .pipe(gulp.dest(buildDir + '/css/'))
});
gulp.task('vendor', ['vendor:javascript', 'vendor:styles']);

/* Environment based config */
gulp.task('config', ['environment'], function () {
    gulp.src('./config.js')
        .pipe(replace('<% apiUrl %>', env.apiUrl))
        .pipe(gulp.dest('./src/main/javascript'));
});

/* Environment Tasks */
gulp.task('environment', function () {
    if (yargs.env !== undefined && ENVS[yargs.env] !== undefined) {
        env = ENVS[yargs.env];
        passedArg = yargs.env;
    }
});

/* Testing Tasks */
gulp.task('karma', ['build'], function (done) {
    var files = [
        //TODO: figure this out
    ];
    if (yargs.f !== undefined) {
        files.push(yargs.f);
    } else {
        files.push('./src/test/coffeescript/**/*.coffee');
    }
    gulp.src(files).pipe(karma({
        files: files,
        configFile: __dirname + '/spec/karma.conf.coffee',
        singleRun: true
    })).on('error', function (err) {
        process.exit(1);
    });
});

gulp.task('karma:run', ['reset'], function () {
    gulp.start('karma');
});

gulp.task('test', function () {
    yargs.env = 'test';
    gulp.start('karma:run');
});

/* Default Tasks */
gulp.task('build', ['environment', 'config', 'scss', 'vendor', 'browserify']);
gulp.task('default', ['build']);