/**
 * Build docker image from Dockerfile with environment variables:
 * - DOCKER_REPO
 * - DOCKER_USERNAME
 * - DOCKER_PASSWORD
 * @param config Map variables: dockerFile, dockerImage
 * @return
 */
def call(Map config=[:]) {
    sh "docker login ${env.DOCKER_REPO} --username ${env.DOCKER_USERNAME} --password ${env.DOCKER_PASSWORD}"
    sh "docker build -f ${config.dockerFile} -t ${config.dockerImage} ."
    sh "docker push ${config.dockerImage}"
    sh "docker logout ${env.DOCKER_REPO}"
}

