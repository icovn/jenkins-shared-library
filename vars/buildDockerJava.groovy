/**
 * Build docker image using jib-maven-plugin with credentials:
 * - docker-repo
 * - docker-username
 * - docker-password
 * @param config Map variables: moduleName
 * @return
 */
def call(Map config=[:]) {
    sh "docker login ${credentials("docker-repo")} --username ${credentials("docker-username")} --password ${credentials("docker-password")}"
    sh "cd ${config.moduleName} && mvn package -Dmaven.test.skip=true"
    sh "docker logout ${credentials("docker-repo")}"
}
