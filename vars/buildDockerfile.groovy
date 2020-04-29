/**
 * Build docker image from Dockerfile with credentials:
 * - docker-repo
 * - docker-username
 * - docker-password
 * @param config Map variables: dockerFile, dockerImage
 * @return
 */
def call(Map config=[:]) {
    sh "docker login ${credentials("docker-repo")} --username ${credentials("docker-username")} --password ${credentials("docker-password")}"
    sh "docker build -f ${config.dockerFile} -t ${config.dockerImage} ."
    sh "docker push ${config.dockerImage}"
    sh "docker logout ${credentials("docker-repo")}"
}

