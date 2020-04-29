/**
 * Build docker image using jib-maven-plugin with credentials:
 * - docker-repo
 * - docker-username
 * - docker-password
 * @param config Map variables: moduleName
 * @return
 */
def call(Map config=[:]) {
    sh "docker login ${credentials id: 'docker-repo'} --username ${credentials id: 'docker-username'} --password ${credentials id: 'docker-password'}"
    sh "cd ${config.moduleName} && mvn package -Dmaven.test.skip=true"
    sh "docker logout ${credentials id: 'docker-repo'}"
}
