#*# Inverted Index: A pre-processing step to construct a 
#\   data structure that associates each word in collection with
#\   a list of documents where the word is present...
#\ Can be simply the sentences/lines a word appears in.
#\ The index can handle queries with time complexity O(1)! 
#\ Thanks to the inverted index, we are now able to query any number 
# \  of documents (as long as they fit in memory) in constant time.
#\ Building the inverted index structure is an expensive operation,
#\  as it requires you to encode every possible query, but the 
#\  benefits are great and may be worthwhile longterm.
index = {}
for i, doc in enumerate(docs):
	# iterate over each term in the document
	for word in doc.split():
		# build list containing the indices where term appears
		if word not in index:
			index[word] = [i]
		else:
			index[word].append(i)


#results = index["search_term"]
#results_documents = [docs[i] for i in results]