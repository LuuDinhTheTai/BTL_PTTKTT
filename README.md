# Trong Binary Search
1, Cài đặt môi trường, chạy BS **(D1)**

# Trong Union-Find
2, Bổ sung code chạy UF

# Trong BagQueueStack
3, Bổ sung code, chạy Stack **(D2)**
4, Bổ sung code, Chạy Queue **(D3)**
5, Bổ sung lớp chia nguyên **(D4)**

# Trong Beyond
6, Khôi phục lớp inversions và áp dụng cho danh sách lớp chưa sx với 10 sinh viên
7, Khôi phục Merge - Trong Sorting
8, Khôi phục Closestpair
9, Quick3Way

# Trong Sorting
10, Chuyển MaxPQ -> MinPQ **(D19)**
11, IndexMinPQ -> IndexMaxPQ **(D20)**
12, VDate **(D5)**
13, Chuyển Transaction -> Student – IN danh sách student theo hoTen, ngaySinh, DtbChung **(D6)**
14, In ra top M sinh viên (điểm TB chung cao nhất) **(D7)**

# Trong 04GreedyAlgorithmsI.pdf
15, Interval Scheduling
    Tìm tập hợp có nhiều công việc nhất: tạo mảng Job, tạo MinPQ (Job)
=> Job result[]
16,Interval Parfit
    Tìm số phòng nhỏ nhất có từng đấy môn để k có 2 môn cùng lúc cùng 1 phòng (tương tự câu trên thay job → lecture => int room
17,Min lateness
    Tìm cách sx mà ra được độ trễ tối đa giữa các công việc là nhỏ nhất

# Trong Graph1
18, Khôi phục DijsktraSP  
19, Bổ sung DijsktraSD
20, Bổ sung DijsktraAllPairs
21, Cài đặt Prim **(D16)**
22, Cài đặt Kruscal **(D17)**

# Trong Searching
23, Khôi phục BinarySearchSimpleTable **(D8)**
24, Danh sách sinh viên
    Đọc file SV.csv  => ST < MaSV, SV > **(D9)**
25, In danh sách sinh viên theo mã, theo tên
    Thêm hàm Put(MaSV, SV), Cho MaSV tìm SV, In danh sách SV **(D10)**
26, Tính TBC
ST Bangdiem < Mon,double >, tạo thêm lớp Mon(ten, soTC,…) **D(11)**
27, Nhập điểm môn
    Tạo đối tượng cho danh sách lớp môn 
        - ST   dsLop < string, Student S >;
        - Mon  mon; **(D12)**
28, Tính TBchungHK
    TBchungHK (int kythu) { Mon(ten, soTC, kythu )…} **(D13)**
29, Tổng kết HK lớp
    TongKetHK (int kythu) { for (Student s: dsLop)  sv.TBchungHK (); }
    => print “MaSV, dtb HK” **(D14)**
30, Thí sinh _ bảng điểm - Hashtable
    Class ThiSinh { hodem, ten, ngaysinh, dtbChungPT } 
    --mỗi TS có 1 bảng đ
    Tạo 1 hashtable < ThiSinh, ST <Mon, diem> > 
    --không có thí sinh nào trùng cả 4 thuộc tính, Thisinh cần có phương thúc hashcode (vì ko có maTS)
    **(D15)**
31, Nhập điểm thi đại học của thí sinh
    File điểm từ {hodem, ten, ngaysinh, dtbChungPT } thêm ← { toán, lý, hóa}
32, Tạo FileFrequencyIndex
    Trả về danh sách các cặp <file, số lần xuất hiện > -- ST <string, ST<file, interger>

# Trong BackTracking
33, Khôi phục AllNQueens

# Trong Context
34, Đóng gói Knapsack **(D18)**

# Trong Graph
35, Bellman-Ford 1 đích	+ WeightEdgeDirectedGraph_T (túi cạnh vào 1 đỉnh) + WeightEdgeDirectedGraph_Cycle_T
36, Bellman-FordAllPair
37, Thêm function +double val_Mincut + set A và set B
Tạo EdmondsBranching
38, Vertex node, SuperNode, Directed Edge
39, DirectedEdgeDigraph_T (với Vertex)
40, DirectedEdgeDigraphCycle_T  (với Vertex)
41, EdmondsBranching