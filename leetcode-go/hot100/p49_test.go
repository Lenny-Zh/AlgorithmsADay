package hot100

import (
	"fmt"
	"sort"
	"testing"
)

func TestP49(t *testing.T) {
	fmt.Printf("%v", groupAnagrams([]string{"eat", "tea", "tan", "ate", "nat", "bat"}))
}

func groupAnagrams(strs []string) [][]string {
	res := make([][]string, 0)
	mp := make(map[string][]string, 0)
	for _, str := range strs {
		s := []byte(str)
		sort.Slice(s, func(i, j int) bool { return s[i] < s[j] })
		sortedStr := string(s)
		mp[sortedStr] = append(mp[sortedStr], str)
	}
	for _, val := range mp {
		res = append(res, val)
	}
	return res
}
