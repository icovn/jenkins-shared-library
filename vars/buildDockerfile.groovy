/**
 * Build docker image from Dockerfile with credentials:
 * - docker-repo
 * - docker-username
 * - docker-password
 * @param config Map variables: dockerFile, dockerImage
 * @return
 */
def call(Map config=[:]) {
    sh "docker login ${credentials id: 'docker-repo'} --username ${credentials id: 'docker-username'} --password ${credentials id: 'docker-password'}"
    sh "docker build -f ${config.dockerFile} -t ${config.dockerImage} ."
    sh "docker push ${config.dockerImage}"
    sh "docker logout ${credentials id: 'docker-repo'}"
}

