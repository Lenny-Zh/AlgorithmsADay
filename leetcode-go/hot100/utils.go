package hot100

func Get2DBoolArray(d1, d2 int) [][]bool {
	arr := make([][]bool, d1)
	for i := 0; i < d1; i++ {
		arr[i] = make([]bool, d2)
	}
	return arr
}

func Get2DIntArray(d1, d2 int) [][]int {
	arr := make([][]int, d1)
	for i := 0; i < d1; i++ {
		arr[i] = make([]int, d2)
	}
	return arr
}

type ListNode struct {
	Val  int
	Next *ListNode
}

func SortArrayAes(arr []int) {
	for i := 0; i < len(arr); i++ {
		for j := i + 1; j < len(arr); j++ {
			if arr[i] > arr[j] {
				// 数据交换
				arr[i], arr[j] = arr[j], arr[i]
			}
		}
	}
}

func Sort2DArrayAesByFirstNumbers(arr [][]int) {
	for i := 0; i < len(arr); i++ {
		for j := i + 1; j < len(arr); j++ {
			if arr[i][0] > arr[j][0] {
				// 数据交换
				arr[i][0], arr[j][0] = arr[j][0], arr[i][0]
			}
		}
	}
}

func SortArrayDes(arr []int) {
	for i := 0; i < len(arr); i++ {
		for j := i + 1; j < len(arr); j++ {
			if arr[i] < arr[j] {
				// 数据交换
				arr[i], arr[j] = arr[j], arr[i]
			}
		}
	}
}

func MaxInt(a, b int) int {
	if a > b {
		return a
	} else {
		return b
	}
}
