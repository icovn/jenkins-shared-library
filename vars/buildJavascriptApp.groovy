def call(Map config = [:], Closure body) {
    node("reactjs") {
        git url: config.url

        stage("Install") {
            sh "yarn install"
        }

        stage("Test") {
            sh "yarn build"
        }

        body()
    }
}