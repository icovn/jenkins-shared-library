/**
 * Deploy docker image to Rancher2 with environment variables:
 * - RANCHER_ADDRESS
 * - RANCHER_CONTEXT
 * - RANCHER_TOKEN
 * @param config Map variables: moduleName, dockerImage
 * @return
 */
def call(Map config=[:]) {
    sh "rancher login ${env.RANCHER_ADDRESS} --context ${env.RANCHER_CONTEXT} --token ${env.RANCHER_TOKEN} --skip-verify"
    sh "rancher kubectl -n ${env.RANCHER_NAMESPACE} set image deployment.v1.apps/${config.moduleName} ${config.moduleName}=${config.dockerImage}"
}
