def call(Map config=[:]) {
    def response = httpRequest 'https://google.com.vn'
    return response
}

def test1(url) {
    def response = httpRequest url
    return response
}
