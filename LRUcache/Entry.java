package LRUcache;
/*
 * ��һ��ϵͳ֮�����һ��Cache�����������n�������Լ�ϵͳ����Ӧ��
what data structure would you use to implement the cache in the later to support following operations.

��ʲô�������ݽṹ������Cache������������Ĳ����أ�
[a] When a request comes look it up in the cache and if it hits then return the response from here and do not pass the request to the system
[b] If the request is not found in the cache then pass it on to the system
[c] Since cache can only store the last n requests, Insert the n+1th request in the cache and delete one of the older requests from the cache

��ΪCacheֻ�������µ�n��������Cache�����n+1������ʱ����Cache��ɾ����ɵ�����

[d]Design one cache such that all operations can be done in O(1) �C lookup, delete and insert.
 */
public class Entry {
    Entry prev;
    Entry next;
    Object value;
    Object key;
}
