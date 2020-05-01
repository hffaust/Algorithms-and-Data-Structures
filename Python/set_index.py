#*# Sets contain only unique elements.
#\  Sets expose a number of operations such as the following:
#\    s.union(t) ---> O(S + T)
#\    s.intersection(t) ---> O(min(S,T))
#\    s.difference(t) ---> O(S)
#\

# Building an index using sets
index = {}
for i, doc in enumerate(docs):
	# iterate over each term in the document
	for word in doc.split():
		# build a set containing the indices where the term appears
		if word not in indes:
			index[word] = {i}
		else:
			index[word].add(i)

# Querying the documents containing both "blue" and "zebra"
# index['blue'].intersection(index['zebra'])