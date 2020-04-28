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
