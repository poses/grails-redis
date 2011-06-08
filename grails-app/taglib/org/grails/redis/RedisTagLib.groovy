package org.grails.redis

class RedisTagLib {
    def redisService

    static namespace = "redis"

    def memoize = { attrs, body ->
        String key = attrs.key

        if (!key) throw new IllegalArgumentException("[key] attribute must be specified for memoize!")

        out << redisService.memoize(key) { body() ?: "" }
    }
}