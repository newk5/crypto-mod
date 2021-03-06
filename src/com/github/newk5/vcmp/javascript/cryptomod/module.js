"use strict";
module.exports = {
    SHA512: function (text, callback) {
        return CryptoWrapper.SHA512(text, callback);
    },
    SHA256: function (text,callback) {
        return CryptoWrapper.SHA256(text, callback);
    },
    MD5: function (text, callback) {
        return CryptoWrapper.MD5(text, callback);
    },
    SHA384: function (text, callback) {
        return CryptoWrapper.SHA384(text, callback);
    },
    SHA224: function (text, callback) {
        return CryptoWrapper.SHA224(text, callback);
    },
    encodeBase64: function (text, callback) {
        return CryptoWrapper.encodeBase64(text, callback);
    },
    decodeBase64: function (text, callback) {
        return CryptoWrapper.decodeBase64(text, callback);
    }

}