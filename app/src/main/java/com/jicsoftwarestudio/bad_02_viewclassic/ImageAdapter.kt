import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jicsoftwarestudio.bad_02_viewclassic.MovieDetailActivity
import com.jicsoftwarestudio.bad_02_viewclassic.R

class ImageAdapter(private val imageList: List<Int>,
                   private val titleList: List<String>,
                   private val timeList: List<String>,
                   private val rateList: List<String>,
                   private val genreList: List<String>,
                   private val overviewList: List<String>) : RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_image, parent, false)
        return ImageViewHolder(view)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val actualPosition = position % imageList.size
        val imageResId = imageList[actualPosition]
        val textTitle = titleList[actualPosition]
        val textTime = timeList[actualPosition]
        val textRate = rateList[actualPosition]
        holder.imageView.setImageResource(imageResId)
        holder.textTitle.text = textTitle
        holder.textTime.text = textTime
        holder.textRate.text = textRate
    }

    override fun getItemCount(): Int {
        return Int.MAX_VALUE
    }
    inner class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
        val textTitle: TextView = itemView.findViewById(R.id.textTitle)
        val textTime: TextView = itemView.findViewById(R.id.textTime)
        val textRate: TextView = itemView.findViewById(R.id.textRate)

        fun bind(imageRes: Int, title: String, time: String, rate: String, genre: String, overview: String) {
            imageView.setOnClickListener {
                val context = it.context
                val intent = Intent(context, MovieDetailActivity::class.java).apply {
                    putExtra("IMAGE_RES", imageRes)
                    putExtra("TITLE", title)
                    putExtra("TIME", time)
                    putExtra("RATE", rate)
                    putExtra("GENRE", genre)
                    putExtra("OVERVIEW", overview)
                }
                context.startActivity(intent)
            }
        }
    }
}
