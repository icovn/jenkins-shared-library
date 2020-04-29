/**
 *
 * @param pipelineParams Map variables: gitBranch, gitCredentialsId, gitUrl, childModules
 * @return
 */
def call(Map pipelineParams) {
    pipeline {
        agent {
            node {
                label pipelineParams.node
            }
        }
        stages {
            stage('checkout git') {
                steps {
                    git branch: pipelineParams.gitBranch, credentialsId: pipelineParams.gitCredentialsId, url: pipelineParams.gitUrl
                }
            }

//            stage('compile') {
//                steps {
//                    sh 'mvn clean package -DskipTests=true'
//                }
//            }

            stage('build sub modules') {
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
}

