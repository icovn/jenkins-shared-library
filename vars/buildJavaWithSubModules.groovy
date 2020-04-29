/**
 *
 * @param pipelineParams Map variables: gitBranch, gitCredentialsId, gitUrl, childModules
 * @return
 */
def call(Map pipelineParams) {
    stages {
        stage('checkout git') {
            steps {
                git branch: pipelineParams.gitBranch, credentialsId: pipelineParams.gitCredentialsId, url: pipelineParams.gitUrl
            }
        }

        stage('build') {
            steps {
                sh 'mvn clean package -DskipTests=true'
            }
        }

        stage('build child modules') {
            steps {
                buildJavaSubModule modules: pipelineParams.childModules
            }
        }
    }
    post {
        failure {
            notifyDiscord title: "Pipeline failed", description: "git ${pipelineParams.gitUrl}"
        }
    }
}

