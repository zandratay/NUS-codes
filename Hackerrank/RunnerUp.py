if __name__ == '__main__':
    n = int(input())
    arr = map(int, input().split())
    arr = list(arr)
    
    new_list = [int(i) for i in arr]
    new_list.sort()
    new_list = list( dict.fromkeys(new_list) )
    print(new_list[len(new_list) - 2])
