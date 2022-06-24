package hot100

func Get2DBoolArray(d1, d2 int) [][]bool {
	arr := make([][]bool, d1)
	for i := 0; i < d2; i++ {
		arr[i] = make([]bool, d2)
	}
	return arr
}

func Get2DIntArray(d1, d2 int) [][]int {
	arr := make([][]int, d1)
	for i := 0; i < d2; i++ {
		arr[i] = make([]int, d2)
	}
	return arr
}

type ListNode struct {
	Val  int
	Next *ListNode
}
