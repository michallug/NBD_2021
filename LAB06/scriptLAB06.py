import riak
srv = riak.RiakClient(pb_port=8087)
bucket = srv.bucket('s17190')


def insert_update(key, value):
    	obj = bucket.new(key, data=value)
	obj.store()
	return 'Dodano', key

def get(key):
    	obj = bucket.get(key)
	return obj.data

def delete(key):
	obj = bucket.get(key)
	obj.delete()
	return 'Usunieto', key

####################################################

item_key = 'program'
item = '{"name": "Program", "source": "Python", "price": 5}'
item_update = '{"name": "Program", "source": "Python", "price": 1000}'

print('1. Dodanie')
print(insert_update(item_key, item))

print('2. Wypisanie')
print(get('program'))

print('3. Modyfikacja')
print(insert_update(item_key, item_update))

print('4. Wypisanie po modyfikacji')
print(get('program'))

print('5. Usuniecie')
print(delete('program'))

print('6. Proba pobrania')
print(get('program'))