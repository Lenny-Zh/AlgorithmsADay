### DFS模板

#### 递归写法
1. 判断结束条件,是否访问过节点
2. 添加当前节点访问记录,处理当前节点
3. 遍历节点下所有子节点递归处理

```

visited = set()

def dfs(node, visited):
    // 1. 如果节点已经遍历过 ,直接返回( 临界条件处理 )
    if node in visited: 
    	return 

    // 添加
	visited.add(node) 

	// 处理当前节点
	...
    // 进入下一层
	for next_node in node.children(): 
		if not next_node in visited: 
			dfs(next_node, visited)
```

#### 非递归写法

```$xslt
def DFS(self, tree): 

	if tree.root is None: 
		return [] 

	visited, stack = [], [tree.root]

	while stack: 
		node = stack.pop() 
		visited.add(node)

		process (node) 
		nodes = generate_related_nodes(node) 
		stack.push(nodes) 

	# other processing work 
	...
```