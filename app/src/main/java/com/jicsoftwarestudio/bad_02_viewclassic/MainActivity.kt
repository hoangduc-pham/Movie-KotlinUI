package com.jicsoftwarestudio.bad_02_viewclassic

import ImageAdapter
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import androidx.viewpager2.widget.ViewPager2

class MainActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager2
    private lateinit var imageAdapter: ImageAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Duyệt qua từng id và thiết lập sự kiện click
        val imageViewIds = arrayOf(
            R.id.mv,
            R.id.mv2,
            R.id.mv3,
            R.id.mv4,
            R.id.mv5,
            R.id.mv6,
            R.id.mv7,
            R.id.mv8,
            R.id.mv9,
        )
        viewPager = findViewById(R.id.viewPager)
        // Example image list
        val imageList = listOf(
            R.drawable.mv,
            R.drawable.mv2,
            R.drawable.mv3,
            R.drawable.mv4,
            R.drawable.mv5,
            R.drawable.mv6,
            R.drawable.mv7,
            R.drawable.mv8,
            R.drawable.mv9,
            R.drawable.mv10,
        )
        val titleList = listOf(
            "Harry Potter: Đũa thần",
            "Doctor Strange: Phù thủy tối thượng",
            "Người khổng lồ xanh",
            "Người nhện: No way home",
            "Người sói: Ám ảnh",
            "Quý ông Real Madrid",
            "Captain America: Đội trưởng Mỹ",
            "Hiệp sĩ áo đen",
            "Avatar: Cuộc chiến không hồi kết",
            "Deadpool: Sát thủ hài hước"
        )
        val timeList = listOf(
            "02 Dec 2022",
            "25 Jun 2024",
            "05 May 2023",
            "09 May 2026",
            "05 May 2023",
            "09 May 2026",
            "05 May 2023",
            "09 May 2026",
            "05 May 2023",
            "09 May 2026"
        )
        val rateList = listOf(
            "8.6/10",
            "7.0/10",
            "5.5/10",
            "8.6/10",
            "7.0/10",
            "5.5/10",
            "8.6/10",
            "7.0/10",
            "5.5/10",
            "5.5/10"
        )
        val genreList = listOf(
            "Phiêu lưu, Giả tưởng",
            "Hành động, Phiêu lưu",
            "Hành động, Khoa học viễn tưởng",
            "Hành động, Phiêu lưu",
            "Hành động, Giả tưởng",
            "Thể thao",
            "Hành động, Phiêu lưu",
            "Hành động, Phiêu lưu",
            "Giả tưởng, Phiêu lưu",
            "Hài, Hành động"
        )
        val overviewList = listOf(
            "Harry Potter là một cậu bé phù thủy bị bỏ rơi khi còn nhỏ, sống cùng gia đình dì dượng và hai người anh chị. Khi biết được mình là phù thủy và có một thế giới phép thuật rộng lớn phía trước, Harry bắt đầu hành trình khám phá sức mạnh của mình và đối mặt với những thử thách nguy hiểm.",
            "Doctor Strange là một bác sĩ phẫu thuật xuất sắc, nhưng sự nghiệp của anh bị đe dọa sau một tai nạn xe hơi tàn khốc. Anh phát hiện ra sự tồn tại của thế giới phép thuật và học hỏi nghệ thuật phép thuật để trở thành một phù thủy mạnh mẽ.",
            "Người khổng lồ xanh là câu chuyện về một người hùng bí ẩn với sức mạnh phi thường, bảo vệ thành phố khỏi những thế lực đen tối. Anh phải đối mặt với nhiều kẻ thù và những mối nguy hiểm đe dọa sự bình yên của thế giới.",
            "Người nhện phải đối mặt với nhiều thử thách mới khi bị cuốn vào một vũ trụ song song. Anh phải tìm cách trở về nhà và đồng thời ngăn chặn những kẻ thù mới và cũ đe dọa cuộc sống của mọi người.",
            "Người sói là một nhân vật với hai mặt: một là một người đàn ông bình thường trong ngày, nhưng khi bão giông đến, anh biến thành một con sói hung dữ. Anh phải chiến đấu để kiểm soát bản thân và bảo vệ những người anh yêu.",
            "Quý ông Real Madrid là một bộ phim kể về cuộc đời của một cầu thủ bóng đá nổi tiếng, với sự nghiệp rực rỡ và những thử thách ngoài sân cỏ. Anh phải đối mặt với áp lực từ công chúng, những mối quan hệ phức tạp và đôi khi cả những vấn đề cá nhân.",
            "Captain America là một người lính dũng cảm trong Chiến tranh thế giới thứ hai, được biến đổi gen để trở thành biểu tượng sống của nước Mỹ. Anh chịu trách nhiệm lớn để bảo vệ quốc gia và thế giới khỏi những mối đe dọa nguy hiểm.",
            "Hiệp sĩ áo đen là một người bảo vệ vùng đất bị áp bức bởi một kẻ thù huyền bí. Anh với sự dũng cảm và trí tuệ của mình, đã chiến đấu để giải cứu những người dân bị áp bức và khôi phục hòa bình cho vùng đất.",
            "Avatar là câu chuyện phiêu lưu của một nhân vật phi thường trên hành tinh Pandora, nơi có những sinh vật và nền văn hóa đầy màu sắc. Anh phải chiến đấu để bảo vệ nền văn hóa bản địa và ngăn chặn cuộc chiến tranh tàn phá của loài người.",
            "Deadpool là một sát thủ chuyên nghiệp với khả năng tự hồi sinh kỳ diệu và tính cách hài hước. Anh phải đối mặt với nhiều kẻ thù nguy hiểm và những âm mưu đen tối, trong khi vẫn giữ được phong cách châm biếm và hài hước của mình."
        )
        for (i in imageViewIds.indices) {
            findViewById<ImageView>(imageViewIds[i]).setOnClickListener {
                val intent = Intent(this, MovieDetailActivity::class.java).apply {
                    putExtra("imageResId", imageList[i])
                    putExtra("title", titleList[i])
                    putExtra("rate", rateList[i])
                    putExtra("genre", genreList[i])
                    putExtra("overview", overviewList[i])
                }
                startActivity(intent)
            }
        }

        imageAdapter = ImageAdapter(imageList, titleList, timeList, rateList, genreList, overviewList)
        viewPager.adapter = imageAdapter
        viewPager.setCurrentItem(Int.MAX_VALUE / 2, true)
    }
}