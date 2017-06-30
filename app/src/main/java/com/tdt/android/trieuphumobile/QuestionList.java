package com.tdt.android.trieuphumobile;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tu on 21-Apr-17.
 */

class QuestionList {
    List<QuestionItem> listQuestion;

    public QuestionList() {

        listQuestion = new ArrayList<>();

        QuestionItem q1 = new QuestionItem("Hệ điều hành Windows gắn liền với tên tuổi của ai?", "A: Elon Musk", "B: Bill Gates", "C: Mark Zuckerberg", "D: Steve Jobs", "B");

        QuestionItem q2 = new QuestionItem("Thủ đô của nước Ý là gì?", "A: Bắc Kinh", "B: Madrid", "C: Roma", "D: Hà Nội", "C");

        QuestionItem q3 = new QuestionItem("Giải Grand Slam đầu tiên trong năm là giải nào?", "A: Australian Open", "B: Wimbledon", "C: Roland Garos", "D: US Open", "A");

        QuestionItem q4 = new QuestionItem("Đâu là tên của một hãng điện thoại di động?", "A: Android", "B: HTC", "C: Chrome", "D: Mobifone", "B");

        QuestionItem q5 = new QuestionItem("Tác giả của tác phẩm \"Bình Ngô đại cáo\"?", "A: Nguyễn Trãi", "B: Hồ Chí Minh", "C: Lý Thường Kiệt", "D: Nguyễn Du", "A");

        QuestionItem q6 = new QuestionItem("Phần mềm nào sau đây dùng để soạn thảo văn bản?", "A: Chrome", "B: Excel", "C: Photoshop", "D: Word", "D");

        QuestionItem q7 = new QuestionItem("Ban nhạc ABBA đến từ đất nước nào?", "A: Anh", "B: Hà Lan", "C: Thụy Điển", "D: Mỹ", "C");

        QuestionItem q8 = new QuestionItem("An Dương Vương đặt tên quốc hiệu nước ta là gì?", "A: Âu Lạc", "B: Vạn Xuân", "C: Đại Việt", "D: Đại Cồ Việt", "A");

        QuestionItem q9 = new QuestionItem("Bệnh cúm lây truyền qua đường nào?", "A: Tiêu hóa", "B: Hô hấp", "C: Tình dục", "D: Máu", "B");

        QuestionItem q10 = new QuestionItem("Người ta hay thường nấu canh cua với thứ gì?", "A: Củ cải", "B: Rau đay", "C: Cà rốt", "D: Rau muống", "B");

        QuestionItem q11 = new QuestionItem("Định lý Vi-et được áp dụng trong lĩnh vực nào?", "A: Toán học", "B: Vật lý", "C: Hóa học", "D: Sinh học", "A");

        QuestionItem q12 = new QuestionItem("Theo một câu hát thì: \"Ba thương con vì con giống mẹ. Mẹ thương con vì con giống ...\" ai?", "A: Ba", "B: Bác đầu ngõ", "C: Ông hàng xóm", "D: Bác chủ nhà", "A");

        QuestionItem q13 = new QuestionItem("Từ nào còn thiếu trong câu thơ sau: \"Gió đưa ... la đà. Tiếng chuông Trấn Vũ canh gà Thọ Xương\"?", "A: Cành dứa", "B: Cành quất", "C: Cành lá", "D: Cành trúc", "D");

        QuestionItem q14 = new QuestionItem("Đâu là một bài hát nổi tiếng của ca sĩ trẻ Lê Thiện Hiếu?", "A: Họ hàng anh", "B: Cô bác anh", "C: Ông bà anh", "D: Chị em anh", "C");

        QuestionItem q15 = new QuestionItem("Đất nước Tây Ban Nha được mệnh danh là gì?", "A: Xứ sở chuột túi", "B: Xứ sở gấu trắng", "C: Xứ sở bò tót", "D: Xứ sở chim cánh cụt", "C");

        QuestionItem q16 = new QuestionItem("Đâu là thủ đô của Malaysia?", "A: Pennang", "B: Kuala Lumpur", "C: Kuching", "D: Kuantan", "B");

        QuestionItem q17 = new QuestionItem("Người cố làm tỏ ra vẻ có khí phách, nhưng thực chất lại hèn nhát gọi là gì?", "A: Anh hùng khói", "B: Anh hùng rạ", "C: Anh hùng rơm", "D: Anh hùng thóc", "C");

        QuestionItem q18 = new QuestionItem("Cầu thủ nào là chủ nhân của giải thưởng Quả bóng vàng 2016?", "A: Cristiano Ronaldo", "B: Lionel Messi", "C: Gareth Bale", "D: Antoine Griezmann", "A");

        QuestionItem q19 = new QuestionItem("Vườn quốc gia Núi Chúa thuộc địa phận tỉnh nào của nước ta?", "A: Ninh Bình", "B: Ninh Thuận", "C: Bắc Ninh", "D: Tây Ninh", "B");

        QuestionItem q20 = new QuestionItem("Đâu là một sáng tác của nhạc sĩ trẻ Phan Mạnh Quỳnh?", "A: Vợ người ta", "B: Vợ người ấy", "C: Vợ người xưa", "D: Vợ người kia", "A");

        QuestionItem q21 = new QuestionItem("Đâu không phải là nhân vật hư cấu, một siêu anh hùng?", "A: Thuyền trưởng Phillips", "B: Người sắt", "C: Người nhện", "D: Người dơi", "A");

        QuestionItem q22 = new QuestionItem("Ai được bình chọn là vận động viên tiêu biểu Việt Nam năm 2016?", "A: Nguyễn Thị Ánh Viên", "B: Hoàng Xuân Vinh", "C: Lý Hoàng Nam", "D: Lê Công Vinh", "B");

        QuestionItem q23 = new QuestionItem("Hiện tượng \"Pen pineapple apple pen\" là bài hát do nghệ sỹ nước nào trình bày?", "A: Thái Lan", "B: Nhật Bản", "C: Hàn Quốc", "D: Myanmar", "B");

        QuestionItem q24 = new QuestionItem("Thành Diên Khánh là địa danh thuộc tỉnh thành nào?", "A: Lâm Đồng", "B: Khánh Hòa", "C: Phú Yên", "D: Đà Nẵng", "B");

        QuestionItem q25 = new QuestionItem("Album nào là album cuối cùng của ban nhạc huyền thoại The Beatles?", "A: Beatles for sale", "B: Help!", "C: The Beatles", "D: Let it be", "D");

        QuestionItem q26 = new QuestionItem("Từ nào sau đây viết đúng chính tả?", "A: Ngặt nghèo", "B: Ngoặt nghèo", "C: Ngặt ngoèo", "D: Ngoặt nghè", "A");

        QuestionItem q27 = new QuestionItem("Trong chè lam truyền thống không thể thiếu vị của củ gì?", "A: Tỏi", "B: Nghệ", "C: Gừng", "D: Tam thất", "C");

        QuestionItem q28 = new QuestionItem("Vận động viên nước nào đang giữ kỷ lục Olympic ở nội dung 10m súng ngắn hơi nam?", "A: Nga", "B: Hàn Quốc", "C: Việt Nam", "D: Brazil", "C");

        QuestionItem q29 = new QuestionItem("Cá chép Koi được coi là biểu tượng may mắn trong phong tục quốc gia nào?", "A: Thái Lan", "B: Nhật Bản", "C: Ấn Độ", "D: Myanmar", "B");

        QuestionItem q30 = new QuestionItem("Đâu là tên của một hãng công nghệ?", "A: KFC", "B: BMW", "C: Apple", "D: Honda", "C");

        QuestionItem q31 = new QuestionItem("Rừng Amazon nằm ở khu vực nào?", "A: Trung Đông", "B: Nam Mỹ", "C: Tây Âu", "D: Bắc Á", "B");

        QuestionItem q32 = new QuestionItem("Lễ hội Âm nhạc quốc tế Gió Mùa 2016 có chủ đề là gì?", "A: Sống xanh", "B: Bảo vệ môi trường", "C: Ô nhiễm không khí", "D: Văn hóa giao thông", "D");

        QuestionItem q33 = new QuestionItem("Váy Flamenco là trang phục nổi tiếng của quốc gia nào?", "A: Tây Ban Nha", "B: Brazil", "C: Bồ Đào Nha", "D: Pháp", "A");

        QuestionItem q34 = new QuestionItem("Người ta thường cho vỏ của quả gì vào món chả rươi?", "A: Sung", "B: Quýt", "C: Dứa", "D: Ổi", "B");

        QuestionItem q35 = new QuestionItem("\"Bu\" là gì?", "A: Một loại khóa", "B: Mẹ", "C: Một loại gia vị", "D: Một điệu hát", "B");

        QuestionItem q36 = new QuestionItem("Con phố nào mang tên một nhà cách mạng Việt Nam?", "A: Trần Phú", "B: Bà Huyện Thanh Quan", "C: Nguyễn Khuyến", "D: Lê Văn Hữu", "A");

        QuestionItem q37 = new QuestionItem("Phố Hàng Đường ở Hà Nội gần với chợ nào nhất?", "A: Chợ Mơ", "B: Chợ Nhật Tân", "C: Chợ Bưởi", "D: Chợ Đồng Xuân", "D");

        QuestionItem q38 = new QuestionItem("Sông nào ở miền Bắc?", "A: Sông Gianh", "B: Sông Lô", "C: Sông Tiền", "D: Sông Hậu", "B");

        QuestionItem q39 = new QuestionItem("Sự kiện sập hầm mỏ chấn động thế giới năm 2010 làm 33 thợ mỏ bị mắc kẹt, xảy ra ở quốc gia nào?", "A: Chile", "B: Nhật", "C: Mỹ", "D: Trung Quốc", "A");

        QuestionItem q40 = new QuestionItem("Quốc kỳ của quốc gia nào không có màu đỏ?", "A: Latvia", "B: Malta", "C: Slovenia", "D: Ireland", "D");

        QuestionItem q41 = new QuestionItem("Hồ Lugano thuộc lục địa nào?", "A: Châu Phi", "B: Châu Á", "C: Châu Âu", "D: Châu Úc", "C");

        QuestionItem q42 = new QuestionItem("Đâu là món bánh truyền thống của đồng bào dân tộc Chăm?", "A: Bánh củ sen", "B: Bánh củ gừng", "C: Bánh củ cải", "D: Bánh củ ấu", "B");

        QuestionItem q43 = new QuestionItem("Cây cầu nào ở Iran?", "A: Landwasser Viaduct", "B: Areuse Gorge", "C: Kurilpa", "D: Siosepol", "D");

        QuestionItem q44 = new QuestionItem("Nhà bác học nào đã dùng con lắc làm thí nghiệm để chứng tỏ rằng Trái Đất tự quay quanh trục của nó?", "A: Galileo Galilei", "B: Isaac Newton", "C: Léon Foucault", "D: Christiaan Huygens", "C");

        QuestionItem q45 = new QuestionItem("Quốc gia châu Phi nào lần đầu tiên được đăng cai tổ chức World Cup?", "A: Algeria", "B: Ghana", "C: Nigeria", "D: Nam Phi", "D");

        QuestionItem q46 = new QuestionItem("Khu vực nào trên thế giới được coi là quê hương của cây ca cao?", "A: Bắc Phi", "B: Đông Á", "C: Trung Mỹ", "D: Nam Phi", "C");

        QuestionItem q47 = new QuestionItem("Bút danh nào sau đây không phải của nhạc sỹ Dương Thụ?", "A: Trần Xuân Nam", "B: Vân Đình", "C: Ái Nhạc", "D: Từ Linh", "D");

        QuestionItem q48 = new QuestionItem("Ban nhạc The Beatles nổi tiếng với thể loại nhạc nào sau đây?", "A: Rock", "B: R&B", "C: Pop", "D: EDM", "A");

        QuestionItem q49 = new QuestionItem("Biển Lagi thuộc địa phận tỉnh nào sau đây?", "A: Khánh Hòa", "B: Ninh Thuận", "C: Quảng Bình", "D: Bình Thuận", "D");

        QuestionItem q50 = new QuestionItem("\"Thiên nga vùng Utrecht?\" là biệt danh của cầu thủ nào?", "A: Marco van Basten", "B: Franz Beckenbauer", "C: Lev Yashin", "D: Juan Veron", "A");

        QuestionItem q51 = new QuestionItem("Đâu là tên một bài thơ nổi tiếng của nhà thơ Nguyễn Bính?", "A: Cô hái mơ", "B: Cô hái xoan", "C: Cô hái sim", "D: Cô hái chanh", "A");

        QuestionItem q52 = new QuestionItem("Lông của ngựa bạch có màu gì?", "A: Đen", "B: Trắng", "C: Nâu", "D: Cam", "B");

        QuestionItem q53 = new QuestionItem("Tiểu thuyết \"Số đỏ\" của nhà văn nào?", "A: Nguyễn Nhật Ánh", "B: Nguyễn Quang Sáng", "C: Vũ Trọng Phụng", "D: Nguyên Ngọc", "C");

        QuestionItem q54 = new QuestionItem("\"Em ơi\" là một sáng tác mới của nhạc sĩ - ca sĩ nào?", "A: Vũ Cát Tường", "B: Châu Đăng Khoa", "C: Anh Khoa", "D: Tiên Cookie", "A");

        QuestionItem q55 = new QuestionItem("Bộ phim nào giành giải \"Phim xuất sắc nhất\" tại Lễ trao giải Oscar lần thứ 89?", "A: La La Land", "B: Manchester by the Sea", "C: Moonlight", "D: Sully", "C");

        QuestionItem q56 = new QuestionItem("Hoa hậu thế giới 2016 là người nước nào?", "A: Trung Quốc", "B: Pháp", "C: Nga", "D: Puerto Rico", "D");

        QuestionItem q57 = new QuestionItem("Đèn Hoa Kỳ là tên gọi khác của loại đèn gì?", "A: Đèn dầu", "B: Đèn pin", "C: Đèn huỳnh quang", "D: Đèn sợi đốt", "A");

        QuestionItem q58 = new QuestionItem("Người mẫu nào sau đây nổi tiếng với làn da bạch tạng?", "A: Gigi Hadid", "B: Winnie Harlow", "C: Adriana Lima", "D: Kendall Jenner", "B");

        QuestionItem q59 = new QuestionItem("Nữ diễn viên Emma Stone ;à người nước nào?", "A: Nga", "B: Pháp", "C: Mỹ", "D: Anh", "C");

        QuestionItem q60 = new QuestionItem("Cây cầu nào bắc qua sông Seine & là cây cầu được xây dựng lâu dời nhất ở Paris còn tồn tại cho tới nay?", "A: Cầu Marie", "B: Cầu Hoàng Gia", "C: Cầu Mới", "D: Cầu Đức Bà", "C");

        QuestionItem q61 = new QuestionItem("Đỉnh núi Elbrus nằm ở dãy núi nào", "A: Dãy Karpat", "B: Dãy Alps", "C: Dãy Kavkaz", "D: Dãy Scandinavia", "C");

        QuestionItem q62 = new QuestionItem("Ký hiệu hóa học của nguyên tố Hiđrô được viết như thế nào?", "A: B", "B: C", "C: H", "D: Al", "C");

        QuestionItem q63 = new QuestionItem("Thổ Nhĩ Kỳ không có biên giới với quốc gia nào sau đây?", "A: Hy Lạp", "B: Ý", "C: Bulgaria", "D: Iran", "B");

        QuestionItem q64 = new QuestionItem("Địa danh nào được ví như \"Vịnh Hạ Long trên cạn\"?", "A: Sơn Đoòng", "B: Phong Nha Kẻ Bàng", "C: Động Thiên Đường", "D: Tam Cốc-Bích Động", "D");

        QuestionItem q65 = new QuestionItem("Nam diễn viên nào dành giải \"Nam diễn viên chính xuất sắc nhất\" tại Lễ trao giải Oscar lần thứ 89?", "A: Ryan Gosling", "B: Ryan Renolds", "C: Casey Affleck", "D: Ben Affleck", "C");

        QuestionItem q66 = new QuestionItem("Chiang Mai là tên một tỉnh, thành phố của quốc gia nào?", "A: Malaysia", "B: Thái Lan", "C: Lào", "D: Campuchia", "B");

        QuestionItem q67 = new QuestionItem("Tổng thư ký Liên hợp quốc thứ 9 (hiện nay) là người nước nào?", "A: Hàn Quốc", "B: Bồ Đào Nha", "C: Hà Lan", "D: Brazil", "B");

        QuestionItem q68 = new QuestionItem("\"Laap pet\" ở Thái Lan là món ăn có nguyên liệu chính làm từ thịt con gì?", "A: Cá", "B: Dê", "C: Vịt", "D: Ngựa", "C");

        QuestionItem q69 = new QuestionItem("Joker là kẻ thù truyền kiếp của nhân vật siêu anh hùng nào?", "A: Siêu nhân", "B: Người dơi", "C: Người sắt", "D: Người khổng lồ xanh", "B");

        QuestionItem q70 = new QuestionItem("Đâu không phải là tên gọi của một loài động vật nhuyễn thể?", "A: Chíp chíp", "B: Chem chép", "C: Trùng trục", "D: Cành cạch", "D");

        QuestionItem q71 = new QuestionItem("\"Doner Kebab\" là tên món ăn gì?", "A: Một món cá", "B: Một món bánh", "C: Một món hầm", "D: Một món salad", "B");

        QuestionItem q72 = new QuestionItem("Tay vợt nào vô địch giải quần vợt Paris Masters 2016", "A: Andy Murray", "B: Novak Djokovic", "C: Roger Federer", "D: Rafael Nadal", "A");

        QuestionItem q73 = new QuestionItem("Người ta phải bắc giàn khi trồng loài cây nào?", "A: Rau muống", "B: Rau ngót", "C: Mướp", "D: Thì là", "C");

        QuestionItem q74 = new QuestionItem("Con vật nào không phải bò sát?", "A: Thằn lằn", "B: Báo đốm", "C: Rắn", "D: Cá sấu", "B");

        QuestionItem q75 = new QuestionItem("Đâu là tên bộ phim hoạt hình có nhân vật chính là hai chú soc chuột?", "A: Tiểu thư & gã bụi đời", "B: Đi tìm Dory", "C: Chip & Dale", "D: Câu chuyện đồ chơi", "C");

        QuestionItem q76 = new QuestionItem("Thủ đô của Costa Rica tên gì?", "A: Koln", "B: Warszawa", "C: Hamburg", "D: San José", "D");

        QuestionItem q77 = new QuestionItem("\"Viên đạn Baltimore\" là biệt danh của vận động viên nào?", "A: Usain Bolt", "B: Michael Phelps", "C: Lionel Messi", "D: Lebron James", "B");

        QuestionItem q78 = new QuestionItem("Đâu là tên một bộ phim của đạo diễn Trần Phương?", "A: Dòng sông hoa đỏ", "B: Dòng sông hoa cỏ", "C: Dòng sông hoa trắng", "D: Dòng sông hoa nắng", "C");

        QuestionItem q79 = new QuestionItem("Bảo tàng The Vent Haven tại bang Kentucky, Mỹ là bảo tàng chuyên trưng bày về gì?", "A: Sách", "B: Con rối", "C: Máy bay", "D: Gà rán", "B");

        QuestionItem q80 = new QuestionItem("Đội tuyển nước nào giành được huy chương vàng bóng đã nữ Olympic Rio 2016?", "A: Đức", "B: Pháp", "C: Brazil", "D: Nhật Bản", "A");

        QuestionItem q81 = new QuestionItem("Trong bộ phim \"Mr. Bean\", đôi mắt của chú gấu Teddy được làm bằng gì?", "A: Hạt cườm", "B: Viên sỏi", "C: Thủy tinh", "D: Nút áo", "D");

        QuestionItem q82 = new QuestionItem("Danh họa Jackson Pollock là tác giả của bức họa nào sau đây?", "A: Woman III", "B: Adele Bloch-Bauer", "C: Number 5, 1948", "D: Mona Lisa", "C");

        QuestionItem q83 = new QuestionItem("CPU là viết tắt của khải niệm nào sau đây?", "A: Central Processing Unit", "B: Critical Processing Unit", "C: Crucial Processing Unit", "D: Central Printing Unit", "A");

        QuestionItem q84 = new QuestionItem("Ai là giám đốc điều hành (CEO) của công ty Tesla Motors?", "A: Rupert Stadler", "B: Toyoda Akio", "C: Elon Musk", "D: Tim Cook", "C");

        QuestionItem q85 = new QuestionItem("Trong những danh tướng đời Trần dưới đây, ai được coi là có tài bơi lặn hơn người?", "A: Trần Bình Trọng", "B: Dã Tượng", "C: Nguyễn Chế Nghĩa", "D: Yết Kiêu", "D");

        QuestionItem q86 = new QuestionItem("Làng nghề Phúc Sen (tỉnh Cao Bằng) nổi tiếng với nghề truyền thống gì?", "A: Nấu rượu dân tộc", "B: Điêu khắc đá", "C: Rèn công cụ cầm tay", "D: Thêu ren thổ cẩm", "C");

        QuestionItem q87 = new QuestionItem("Thành phố nào của Thụy Sỹ nằm bên bờ hồ Geneva xinh đẹp?", "A: Lausanne", "B: Zurich", "C: Basel", "D: Berne", "A");

        QuestionItem q88 = new QuestionItem("Vụ FBI yêu cầu Apple mở khóa chiếc iPhone 5c của đối tượng xả súng giết người xảy ra ở thành phố nào sau đây?", "A: Los Angeles", "B: San Bernardino", "C: San Francisco", "D: Memphis", "B");

        QuestionItem q89 = new QuestionItem("Virus Wanna Cry đang gây xôn xao trên toàn thế giới chỉ hoạt dộng trên hệ điều hành nào?", "A: Windows", "B: macOS", "C: Linux", "D: Android", "A");

        QuestionItem q90 = new QuestionItem("Có câu \"Liệu cơm gắp ...\" gì?", "A: Thịt", "B: Mắm", "C: Rau", "D: Cá", "B");

        QuestionItem q91 = new QuestionItem("Từ nào không dùng để chỉ hình dáng của đôi chân?", "A: Thẳng tắp", "B: Cong", "C: Vòng kiềng", "D: Rễ tre", "D");

        QuestionItem q92 = new QuestionItem("Con vật nào không xuất hiện trong tác phẩm \"Dễ Mèn phiêu lưu kí\" của Tô Hoài?", "A: Dễ trũi", "B: Ngựa vằn", "C: Bọ ngựa", "D: Dế mèn", "B");

        QuestionItem q93 = new QuestionItem("Vận động viên Hoàng Xuân Vinh của Việt Nam tham dự Olympic Rio 2016 ở môn thể thao gì?", "A: Cử tạ", "B: Đấu kiếm", "C: Bắn súng", "D: Thể dục dụng cụ", "C");

        QuestionItem q94 = new QuestionItem("Giải vô địch bóng đá thế giới (World Cup) năm 2022 sẽ được tổ chức ở quốc gia nào?", "A: Qatar", "B: Nhật Bản", "C: Tây Ban Nha", "D: Úc", "A");

        QuestionItem q95 = new QuestionItem("Hoa hậu Việt Nam năm 2016 là ai?", "A: Đào thị Hà", "B: Đỗ Mỹ Linh", "C: Huỳnh Thị Thùy Dung", "D: Trần Thị Thu Hiền", "B");

        QuestionItem q96 = new QuestionItem("Vết sẹo trên trán nhân vật Harry Potter có hình gì?", "A: Mặt trời", "B: Đám mây", "C: Tia chớp", "D: Trăng khuyết", "C");

        QuestionItem q97 = new QuestionItem("Giải Nobel Vật lý năm 2016 đã được trao cho các nhà khoa học của quốc gia nào?", "A: Anh", "B: Mỹ", "C: Nhật Bản", "D: Israel", "A");

        QuestionItem q98 = new QuestionItem("Nữ diễn viên Julia Roberts đã vào vai nữ chính trong bộ phim nào sau đây?", "A: Catwoman", "B: Pretty woman", "C: Gravity", "D: One day", "B");

        QuestionItem q99 = new QuestionItem("Dãy núi Rocky nằm trên lãnh thổ của hai quốc gia nào?", "A: Paraguay-Brazil", "B: Uruguay-Argentina", "C: Mỹ-Canada", "D: Venezuela-Colombia", "C");

        QuestionItem q100 = new QuestionItem("Chiếc điện thoại nào bị khai tử trong 2016 do gặp phải vấn đề về cháy nổ?", "A: Samsung Galaxy S7", "B: Samsung Galaxy Note 7", "C: HTC 10", "D: iPhone 7", "");

        listQuestion.add(q1);
        listQuestion.add(q2);
        listQuestion.add(q3);
        listQuestion.add(q4);
        listQuestion.add(q5);
        listQuestion.add(q6);
        listQuestion.add(q7);
        listQuestion.add(q8);
        listQuestion.add(q9);
        listQuestion.add(q10);
        listQuestion.add(q11);
        listQuestion.add(q12);
        listQuestion.add(q13);
        listQuestion.add(q14);
        listQuestion.add(q15);
        listQuestion.add(q16);
        listQuestion.add(q17);
        listQuestion.add(q18);
        listQuestion.add(q19);
        listQuestion.add(q20);
        listQuestion.add(q21);
        listQuestion.add(q22);
        listQuestion.add(q23);
        listQuestion.add(q24);
        listQuestion.add(q25);
        listQuestion.add(q26);
        listQuestion.add(q27);
        listQuestion.add(q28);
        listQuestion.add(q29);
        listQuestion.add(q30);
        listQuestion.add(q31);
        listQuestion.add(q32);
        listQuestion.add(q33);
        listQuestion.add(q34);
        listQuestion.add(q35);
        listQuestion.add(q36);
        listQuestion.add(q37);
        listQuestion.add(q38);
        listQuestion.add(q39);
        listQuestion.add(q40);
        listQuestion.add(q41);
        listQuestion.add(q42);
        listQuestion.add(q43);
        listQuestion.add(q44);
        listQuestion.add(q45);
        listQuestion.add(q46);
        listQuestion.add(q47);
        listQuestion.add(q48);
        listQuestion.add(q49);
        listQuestion.add(q50);
        listQuestion.add(q51);
        listQuestion.add(q52);
        listQuestion.add(q53);
        listQuestion.add(q54);
        listQuestion.add(q55);
        listQuestion.add(q56);
        listQuestion.add(q57);
        listQuestion.add(q58);
        listQuestion.add(q59);
        listQuestion.add(q60);
        listQuestion.add(q61);
        listQuestion.add(q62);
        listQuestion.add(q63);
        listQuestion.add(q64);
        listQuestion.add(q65);
        listQuestion.add(q66);
        listQuestion.add(q67);
        listQuestion.add(q68);
        listQuestion.add(q69);
        listQuestion.add(q70);
        listQuestion.add(q71);
        listQuestion.add(q72);
        listQuestion.add(q73);
        listQuestion.add(q74);
        listQuestion.add(q75);
        listQuestion.add(q76);
        listQuestion.add(q77);
        listQuestion.add(q78);
        listQuestion.add(q79);
        listQuestion.add(q80);
        listQuestion.add(q81);
        listQuestion.add(q82);
        listQuestion.add(q83);
        listQuestion.add(q84);
        listQuestion.add(q85);
        listQuestion.add(q86);
        listQuestion.add(q87);
        listQuestion.add(q88);
        listQuestion.add(q89);
        listQuestion.add(q90);
        listQuestion.add(q91);
        listQuestion.add(q92);
        listQuestion.add(q93);
        listQuestion.add(q94);
        listQuestion.add(q95);
        listQuestion.add(q96);
        listQuestion.add(q97);
        listQuestion.add(q98);
        listQuestion.add(q99);
        listQuestion.add(q100);

    }
}
