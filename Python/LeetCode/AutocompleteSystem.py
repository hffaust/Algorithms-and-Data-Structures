class AutocompleteSystem(object):
    def __init__(self, sentences, times):
        self.partial = []           # previously seen chars of current sentence
        self.matches = []           # matching sentences in decreasing frequency order
        
        self.counts  = collections.defaultdict(int)     # map from sentence to its frequency
        for sentence, count in zip(sentences, times):
            self.counts[sentence] = count

    def input(self, c):
        if c == "#":
            sentence = "".join(self.partial)
            self.counts[sentence] += 1
            self.partial = []       # reset partial and matches
            self.matches = []
            return []
        
        if not self.partial:        # first char of sentence
            self.matches = [(-count, sentence) for sentence, count in self.counts.items() if sentence[0] == c]
            self.matches.sort()
            self.matches = [sentence for _, sentence in self.matches]   # drop the counts
        else:
            i = len(self.partial)   # filter matches for c
            self.matches = [sentence for sentence in self.matches if len(sentence) > i and sentence[i] == c]
            
        self.partial.append(c)
        return self.matches[:3]

# Your AutocompleteSystem object will be instantiated and called as such:
# obj = AutocompleteSystem(sentences, times)
# param_1 = obj.input(c)
