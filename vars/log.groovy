//https://github.com/jenkinsci/ansicolor-plugin
//https://misc.flogisoft.com/bash/tip_colors_and_formatting
//https://blog.mphomphego.co.za/blog/2017/04/13/jenkins-add-color-to-console-output.html

def info(message) {
    //sh ("printf '\\033[1;33m ${message} \\033[0m \$1'")
    sh ("printf 'INFO ${message}'")
}

def error(message) {
    //sh ("printf '\\033[1;31m ${message} \\033[0m \$1'")
    sh ("printf 'ERROR ${message}'")
}

def success(message) {
    //sh ("printf '\\033[1;32m ${message} \\033[0m \$1'")
    sh ("printf 'SUCCESS ${message}'")
}