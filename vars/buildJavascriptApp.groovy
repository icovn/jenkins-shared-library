def call(Map config = [:], Closure body) {
    node {
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