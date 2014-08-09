package LRUcache;
/*
 * 在一个系统之上设计一个Cache，缓存最近的n个请求以及系统的响应。
what data structure would you use to implement the cache in the later to support following operations.

用什么样的数据结构设计这个Cache才能满足下面的操作呢？
[a] When a request comes look it up in the cache and if it hits then return the response from here and do not pass the request to the system
[b] If the request is not found in the cache then pass it on to the system
[c] Since cache can only store the last n requests, Insert the n+1th request in the cache and delete one of the older requests from the cache

因为Cache只缓存最新的n个请求，向Cache插入第n+1个请求时，从Cache中删除最旧的请求。

[d]Design one cache such that all operations can be done in O(1) – lookup, delete and insert.
 */
public class Entry {
    Entry prev;
    Entry next;
    Object value;
    Object key;
}
