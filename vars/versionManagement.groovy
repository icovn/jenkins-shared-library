def call(Map config=[:]) {
    def response = httpRequest 'https://google.com.vn'
    return response
}
