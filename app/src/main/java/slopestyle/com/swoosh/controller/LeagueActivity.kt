package slopestyle.com.swoosh.controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_league.*
import slopestyle.com.swoosh.model.Player
import slopestyle.com.swoosh.R
import slopestyle.com.swoosh.utilities.EXTRA_PLAYER

class LeagueActivity : BaseActivity() {

    var player = Player("", "")
    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putParcelable(EXTRA_PLAYER, player)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        if (savedInstanceState != null) {
            player = savedInstanceState.getParcelable(EXTRA_PLAYER)
        }
    }

    fun leagueNextClicked(view: View) {
        if(player.league != "") {
            val skillActivity = Intent(this, SkillActivity::class.java)
            skillActivity.putExtra(EXTRA_PLAYER, player)
            startActivity(skillActivity)
        } else {
            Toast.makeText(this,"Please select a league.", Toast.LENGTH_SHORT).show()
        }
    }

    fun onMensClicked(view: View) {
      womensLeagueBtn.isChecked = false
      coedLeagueBtn.isChecked = false
      player.league = "mens"
    }

    fun onWomensClicked(view: View) {
      mensLeagueBtn.isChecked = false
      coedLeagueBtn.isChecked = false
      player.league = "womens"
    }

    fun onCoedClicked(view: View) {
      mensLeagueBtn.isChecked = false
      womensLeagueBtn.isChecked = false
      player.league = "co-ed"
    }
}
