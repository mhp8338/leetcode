# leetcode
# Leetcode Introduction

> 本文旨在将leetcode的题型分类

## Pattern: Sliding window

滑动窗口类型的题目经常是用来执行数组或是链表上某个区间（窗口）上的操作。比如找最长的全为1的子数组长度。滑动窗口一般从第一个元素开始，一直往右边一个一个元素挪动。

| Leetcode                       | Java                                                       | Python                                                       |
| ------------------------------ | ---------------------------------------------------------- | ------------------------------------------------------------ |
| 209. Minimum Size Subarray Sum | [Java](https://www.cnblogs.com/xm08030623/p/13462368.html) | [Python](https://www.cnblogs.com/xm08030623/p/13453200.html) |
|                                |                                                            |                                                              |
|                                |                                                            |                                                              |

### 滑动窗口需要记录

| Leetcode                                                  | Java                                                       | Python |
| --------------------------------------------------------- | ---------------------------------------------------------- | ------ |
| Leetcode.3 Longest Substring Without Repeating Characters | [Java](https://www.cnblogs.com/xm08030623/p/13475883.html) |        |
| Leetcode.76 Minimum Window Substring                      | [Java](https://www.cnblogs.com/xm08030623/p/13475945.html) |        |
| Leetcode.438 Find All Anagrams in a String                | [Java](https://www.cnblogs.com/xm08030623/p/13475896.html) |        |

## Pattern: two points

双指针是这样的模式：两个指针朝着左右方向移动（双指针分为**同向双指针**和**异向双指针**），直到他们有一个或是两个都满足某种条件。

使用双指针的优势：若只用一个指针，需多次循环找到你需要的答案，此时将耗时和浪费空间。 

| Leetcode                                   | Java | Python                                                       |
| ------------------------------------------ | ---- | ------------------------------------------------------------ |
| 11. Container With Most Water              |      | [Python](https://www.cnblogs.com/xm08030623/p/13451140.html) |
| 26. Remove Duplicates from Sorted Array    |      | [Python](cnblogs.com/xm08030623/p/13408492.html)             |
| 27. Remove Element                         |      | [Python](https://www.cnblogs.com/xm08030623/p/13396027.html) |
| 75. Sort Colors                            |      | [Python](https://www.cnblogs.com/xm08030623/p/13383824.html) |
| 80. Remove Duplicates from Sorted Array II |      | [Python](https://www.cnblogs.com/xm08030623/p/13409852.html) |
| 88. Merge Sorted Array                     |      | [Python](https://www.cnblogs.com/xm08030623/p/13425625.html) |
| 125. Valid Palindrome                      |      | [python](https://www.cnblogs.com/xm08030623/p/13432595.html) |
| 167. Two Sum II - Input array is sorted    |      | [Python](https://www.cnblogs.com/xm08030623/p/13431743.html) |
| 209. Minimum Size Subarray Sum             |      | [Python](https://www.cnblogs.com/xm08030623/p/13453200.html) |
| 215. Kth Largest Element in an Array       |      | [Python](https://www.cnblogs.com/xm08030623/p/13425621.html) |
| 283. Move Zeroes                           |      | [Python](https://www.cnblogs.com/xm08030623/p/13390349.html) |
| 344. Reverse String                        |      | [Python](https://www.cnblogs.com/xm08030623/p/13440783.html) |
| 345. Reverse Vowels of a String            |      | [Python](https://www.cnblogs.com/xm08030623/p/13444196.html) |

## Pattern: Merge Intervals

区间合并模式是一个用来处理有区间重叠的很高效的技术。在设计到区间的很多问题中，通常咱们需要要么判断是否有重叠，要么合并区间，如果他们重叠的话。

| Leetcode | Java | Python |
| -------- | ---- | ------ |
|          |      |        |
|          |      |        |
|          |      |        |

## Pattern: Collection，集合的使用

利用哈希表以空间换时间

| Leetcode                                | Java                                                       | Python                                                       |
| --------------------------------------- | ---------------------------------------------------------- | ------------------------------------------------------------ |
| 167. Two Sum II - Input array is sorted |                                                            | [Python](https://www.cnblogs.com/xm08030623/p/13431743.html) |
| 202. Happy Number                       | [Java](https://www.cnblogs.com/xm08030623/p/13496589.html) |                                                              |
| 242. Valid Anagram                      | [Java](https://www.cnblogs.com/xm08030623/p/13496576.html) |                                                              |
| 290. Word Pattern                       | [Java](https://www.cnblogs.com/xm08030623/p/13496605.html) |                                                              |
| 350. Intersection of Two Arrays II      | [Java](https://www.cnblogs.com/xm08030623/p/13496540.html) |                                                              |
| 719. Find K-th Smallest Pair Distance   |                                                            |

## Pattern: Cyclic Sort，**循环排序**

这种模式讲述的是一直很好玩的方法：可以用来处理数组中的数值限定在一定的区间的问题。

| Leetcode | Java | Python |
| -------- | ---- | ------ |
|          |      |        |
|          |      |        |
|          |      |        |

## Pattern: In-place Reversal of a LinkedList，**链表翻转**

| Leetcode | Java | Python |
| -------- | ---- | ------ |
|          |      |        |
|          |      |        |
|          |      |        |

## Pattern: Tree Breadth First Search，**树上的BFS**

这种模式基于宽搜（Breadth First Search (BFS)），适用于需要遍历一颗树。借助于队列数据结构，从而能保证树的节点按照他们的层数打印出来。打印完当前层所有元素，才能执行到下一层。所有这种需要遍历树且需要一层一层遍历的问题，都能用这种模式高效解决。

| Leetcode | Java | Python |
| -------- | ---- | ------ |
|          |      |        |
|          |      |        |
|          |      |        |

## Pattern: Tree Depth First Search，**树上的DFS**

树形DFS基于深搜（Depth First Search (DFS)）技术来实现树的遍历。

咱们可以用递归（或是显示栈，如果你想用迭代方式的话）来记录遍历过程中访问过的父节点。

| Leetcode | Java | Python |
| -------- | ---- | ------ |
|          |      |        |
|          |      |        |
|          |      |        |

## Pattern: Two Heaps，**双堆类型**

很多问题中，我们被告知，我们拿到一大把可以分成两队的数字。为了解决这个问题，我们感兴趣的是，怎么把数字分成两半？使得：小的数字都放在一起，大的放在另外一半。双堆模式就能高效解决此类问题。

正如名字所示，该模式用到了两个堆，是不是很难猜？一个最小堆用来找最小元素；一个最大堆，拿到最大元素。这种模式将一半的元素放在最大堆中，这样你可以从这一堆中秒找到最大元素。同理，把剩下一半丢到最小堆中，O(1)时间找到他们中的最小元素。通过这样的方式，这一大堆元素的**中位数**就可以从两个堆的堆顶拿到数字，从而计算出来。

| Leetcode | Java | Python |
| -------- | ---- | ------ |
|          |      |        |
|          |      |        |
|          |      |        |

## Pattern: Subsets，**子集类型，一般都是使用多重DFS**

超级多的编程面试问题都会涉及到排列和组合问题。子集问题模式讲的是用BFS来处理这些问题。

| Leetcode | Java | Python |
| -------- | ---- | ------ |
|          |      |        |
|          |      |        |
|          |      |        |

## Pattern: Modified Binary Search，**改造过的二分**

当你需要解决的问题的输入是排好序的数组，链表，或是排好序的矩阵，要求咱们寻找某些特定元素。这个时候的不二选择就是二分搜索。这种模式是一种超级牛的用二分来解决问题的方式。

| Leetcode | Java | Python |
| -------- | ---- | ------ |
|          |      |        |
|          |      |        |
|          |      |        |

## Pattern: Top ‘K’ Elements，**前K个系列**

任何让我们求解最大/最小/最频繁的K个元素的题，都遵循这种模式。

用来记录这种前K类型的最佳数据结构就是堆了（译者注：在Java中，改了个名，叫优先队列（5））。这种模式借助堆来解决很多这种前K个数值的问题。

| Leetcode                             | Java | Python                                                       |
| ------------------------------------ | ---- | ------------------------------------------------------------ |
| 215. Kth Largest Element in an Array |      | [Python](https://www.cnblogs.com/xm08030623/p/13425621.html) |
|                                      |      |                                                              |
|                                      |      |                                                              |

## Pattern: K-way merge，**多路归并**

K路归并能帮咱们解决那些涉及到多组排好序的数组的问题。

每当你的输入是K个排好序的数组，你就可以用堆来高效顺序遍历其中所有数组的所有元素。你可以将每个数组中最小的一个元素加入到最小堆中，从而得到全局最小值。当我们拿到这个全局最小值之后，再从该元素所在的数组里取出其后面紧挨着的元素，加入堆。如此往复直到处理完所有的元素。

| Leetcode | Java | Python |
| -------- | ---- | ------ |
|          |      |        |
|          |      |        |
|          |      |        |

## Pattern: Topological Sort (Graph)，**拓扑排序类型**

拓扑排序模式用来寻找一种线性的顺序，这些元素之间具有依懒性。比如，如果事件B依赖于事件A，那A在拓扑排序顺序中排在B的前面。

这种模式定义了一种简单方式来理解拓扑排序这种技术。

| Leetcode | Java | Python |
| -------- | ---- | ------ |
|          |      |        |
|          |      |        |
|          |      |        |

## Pattern: Dynamic Programming

### 0/1 Knapsack

| Leetcode | Java | Python |
| -------- | ---- | ------ |
|          |      |        |
|          |      |        |
|          |      |        |

### Unbounded Knapsack

| Leetcode | Java | Python |
| -------- | ---- | ------ |
|          |      |        |
|          |      |        |
|          |      |        |

### Fibonacci Numbers

| Leetcode | Java | Python |
| -------- | ---- | ------ |
|          |      |        |
|          |      |        |
|          |      |        |

### Palindromic Subsequence

| Leetcode | Java | Python |
| -------- | ---- | ------ |
|          |      |        |
|          |      |        |
|          |      |        |

### Longest Common Substring

| Leetcode | Java | Python |
| -------- | ---- | ------ |
|          |      |        |
|          |      |        |
|          |      |        |

## Pattern: Data Structure
