var gulp = require('gulp');
var concat = require('gulp-concat');
var uglify = require('gulp-uglify');
var imagemin = require('gulp-imagemin');
var sourcemaps = require('gulp-sourcemaps');
var del = require('del');

var browserify = require('browserify');
var source = require('vinyl-source-stream');
var buffer = require('vinyl-buffer');

var paths = {
    external_scripts: [
        'node_modules/jquery/dist/jquery.min.js'
    ],
    application_scripts: ['js/**/*.js'],
    images: 'img/**/*'
};

gulp.task('clean', function() {
    return del(['dist']);
});

gulp.task('images', ['clean'], function() {
    return gulp.src(paths.images)
        .pipe(gulp.dest('dist/img'));
});

gulp.task('browserify:js', [], function () {
    return browserify('js/greeting.js').bundle()
        .pipe(source('all.min.js'))
        .pipe(buffer())
        .pipe(uglify())
        .pipe(gulp.dest('dist/js'));
});

gulp.task('default', ['images', 'browserify:js']);