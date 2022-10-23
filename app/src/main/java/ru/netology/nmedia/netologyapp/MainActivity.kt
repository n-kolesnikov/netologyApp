package ru.netology.nmedia.netologyapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.netology.nmedia.netologyapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val post = Post(
            id = 1,
            author = "Нетология. Университет интернет-профессий будущего",
            content = "Привет, это новая Нетология! Когда-то Нетология начиналась с интенсивов по онлайн-маркетингу. Затем появились курсы по дизайну, разработке, аналитике и управлению. Мы растем сами и помогаем расти студентам: от новичков до уверенных профессионалов. Но самое важное остается с нами: мы верим, что в каждом уже есть сила, которая заставляет хотеть больше, целиться выше, бежать быстрее. Наша миссия - помочь встать на путь роста и начать цепочку перемен http://netolo.gy/fyb</string>",
            published = "21 мая в 18:36",
            likedByMe = false,
            likeCount = 999,
            shareCount = 997
        )
        with(binding){
            author.text = post.author
            published.text = post.published
            content.text = post.content
            likeCount.text = likeShareCount(post.likeCount)
            shareCount.text = likeShareCount(post.shareCount)
            if (post.likedByMe){
                like?.setImageResource(R.drawable.ic_post_liked)
            }

            like?.setOnClickListener{
                post.likedByMe = !post.likedByMe
                    if (post.likedByMe) {
                        post.likeCount += 1
                        likeCount.text = likeShareCount(post.likeCount)
                        like.setImageResource(R.drawable.ic_post_liked)
                    } else {
                        post.likeCount -= 1
                        likeCount.text = likeShareCount(post.likeCount)
                        like.setImageResource(R.drawable.ic_post_like)
                    }
            }

            share?.setOnClickListener{
                post.shareCount += 1
                shareCount.text = likeShareCount(post.shareCount)
            }
        }
    }
}

fun likeShareCount (x:Long):String{
    return when (x) {
        in 1..999 -> x.toString()
        in 1000..9999 -> (x/1000).toString() + "." + ((x%1000)/100).toString() + "K"
        in 10000..999999 -> (x/1000).toString() + "K"
        in 1000000..9999999 -> (x/100000).toString() + "." + ((x%10000)/1000).toString() + "K"
        else -> ""
    }
}