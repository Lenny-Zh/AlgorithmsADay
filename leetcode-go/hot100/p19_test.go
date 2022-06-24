package hot100

//func TestP19(t *testing.T) {
//}

func removeNthFromEnd(head *ListNode, n int) *ListNode {
	node := &ListNode{}
	node.Next = head
	first := head
	second := node
	for i := 0; i < n; i++ {
		first = first.Next
	}

	for first != nil {
		second = second.Next
		first = first.Next
	}
	second.Next = second.Next.Next
	return node.Next
}

func removeNthFromEndR(head *ListNode, n int) *ListNode {
	virNode := &ListNode{}
	virNode.Next = head
	first := head
	second := virNode

	for i := 0; i < n; i++ {
		first = first.Next
	}
	for first != nil {
		second = second.Next
		first = first.Next
	}
	second.Next = second.Next.Next
	return virNode.Next
}
