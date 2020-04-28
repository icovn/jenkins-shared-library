//https://www.jenkins.io/doc/pipeline/steps/http_request/
//https://github.com/jenkinsci/http-request-plugin

def call(Map config=[:]) {
    def response = httpRequest 'https://google.com.vn'
    return response
}

def callUrl(url) {
    def response = httpRequest url
    println("Status: "+response.status)
    println("Content: "+response.content)
    return response.content
}
