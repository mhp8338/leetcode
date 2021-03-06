def swap(i, param, arr):
    arr[i], arr[param] = arr[param], arr[i]


class SortAlgorithm(object):
    """
    时间复杂度：O(N^2)
    """
    
    @classmethod
    def selection_sort(cls, arr) -> list:
        """
        选择排序
        """
        for i in range(len(arr)):
            # 找到最小值元素
            min_index = i
            # [i+1,n)找比最小值小的
            for j in range(i + 1, len(arr)):
                if arr[j] < arr[min_index]:
                    min_index = j
            arr[i], arr[min_index] = arr[min_index], arr[i]
        return arr
    
    # 每轮找到当前未处理元素的最大值和最小值的索引
    @classmethod
    def select_sort_optimization(cls, arr) -> list:
        left = 0
        right = len(arr) - 1
        while left < right:
            min_index = left
            max_index = right
            # 每次循环检查min max大小
            if arr[min_index] > arr[max_index]:
                arr[max_index], arr[min_index] = arr[min_index], arr[max_index]
            for i in range(left + 1, right):
                if arr[i] < arr[min_index]:
                    min_index = i
                elif arr[i] > arr[max_index]:
                    max_index = i
            # 每次取出最小最大索引后替换两边的最值
            arr[left], arr[min_index] = arr[min_index], arr[left]
            arr[right], arr[max_index] = arr[max_index], arr[right]
            # 更新left right
            left += 1
            right -= 1
        return arr
    
    @classmethod
    def insert_sort(cls, arr) -> list:
        for i in range(1, len(arr)):
            # (0,i]
            j = i
            e = arr[i]
            # 找位置
            while j > 0 and arr[j - 1] > e:
                arr[j] = arr[j - 1]
                j -= 1
            arr[j] = e
        return arr
    
    @classmethod
    def shell_sort(cls, arr) -> list:
        n = len(arr)
        # gap每次递减2的倍数
        gap = int(n / 2)
        while gap > 0:
            # 插入排序
            for i in range(gap, n):
                temp = arr[i]
                # 生成一个j指针，指向i，此时j指向每组的最后一个
                j = i
                while j >= gap and arr[j - gap] > temp:
                    arr[j] = arr[j - gap]
                    j -= gap
                # 找到要插入的位置
                arr[j] = temp
            gap = int(gap / 2)
        return arr
    
    @classmethod
    def bubble_sort(cls, arr) -> list:
        n = len(arr)
        # 冒泡标志
        swap = False
        while True:
            # 循环初始化是false
            swap = False
            for i in range(1, n):
                if arr[i - 1] > arr[i]:
                    arr[i - 1], arr[i] = arr[i], arr[i - 1]
                    # 冒泡后置为True
                    swap = True
            # 把最大的数放置n，此时更新n的值
            n -= 1
            # 如果该迭代并未发生冒泡，则退出
            if swap is False:
                break
        return arr
    
    @classmethod
    def bubble_sort_optimization(cls, arr) -> list:
        n = len(arr)
        while True:
            new_n = 0
            for i in range(1, n):
                # n=1时，不进入循环
                if arr[i - 1] > arr[i]:
                    swap(i, i - 1, arr)
                    new_n = i
            # 记录最后一次的交换位置，下一轮扫描不考虑
            n = new_n
            if new_n == 0:
                break
        return arr
    
    @staticmethod
    def merge_sort(arr) -> list:
        n = len(arr)
        if n <= 1:
            return arr
        
        if n <= 15:
            return SortAlgorithm.insert_sort(arr)
        
        mid = int(len(arr) / 2)
        left = SortAlgorithm.merge_sort(arr[:mid])
        right = SortAlgorithm.merge_sort(arr[mid:])
        return SortAlgorithm._merge(left, right)
    
    @staticmethod
    def _merge(left, right):
        """
        合并[left,mid] 与[mid+1,right]
        """
        # 优化一：先判定再排序
        left_len = len(left)
        right_len = len(right)
        if left[left_len - 1] <= right[0]:
            return left + right
        c = []
        h = j = 0
        while j < left_len and h < right_len:
            # j -> left h->right
            if left[j] < right[h]:
                c.append(left[j])
                j += 1
            else:
                c.append(right[h])
                h += 1
        # 存在一个到底
        if j == len(left):
            for i in right[h:]:
                c.append(i)
        else:
            for i in left[j:]:
                c.append(i)
        return c
    
    @staticmethod
    def merge_sort_bu(arr) -> list:
        n = len(arr)
        if n <= 1:
            return arr
        
        if n <= 15:
            return SortAlgorithm.insert_sort(arr)
        sz = 1
        while sz < n:
            left = 0
            c = []
            while left < n - sz:
                # [0,sz-1][sz,sz+sz-1]
                c.extend(SortAlgorithm._merge(arr[left: (left + sz)], arr[(left + sz): min(left + sz + sz, n)]))
                left += sz
            sz *= 2
            arr = c
        return arr


if __name__ == '__main__':
    list1 = [1, 3, 4, 7, 9, 2, 3, 1, 1, 3, 4, 7, 9, 2, 3, 1, 1, 3, 4, 7, 9, 2, 3, 1, 1, 3, 4, 7, 9, 2, 3, 1]
    # print(SortAlgorithm.selection_sort(list1))
    # list1.reverse()
    # print(list1)
    # print(SortAlgorithm.insert_sort(list1))
    # print(SortAlgorithm.select_sort_optimization(list1))
    print(SortAlgorithm.merge_sort_bu(list1))
