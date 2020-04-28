/**
 * Build docker image using jib-maven-plugin with environment variables: DOCKER_REPO, DOCKER_USERNAME, DOCKER_PASSWORD
 * @param config Map variables: moduleName
 * @return
 */
def call(Map config=[:]) {
    sh "docker login ${env.DOCKER_REPO} --username ${env.DOCKER_USERNAME} --password ${env.DOCKER_PASSWORD}"
    sh "cd ${config.moduleName} && mvn package -Dmaven.test.skip=true"
    sh "docker logout ${env.DOCKER_REPO}"
}
