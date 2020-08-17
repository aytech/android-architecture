/*
 *
 *  Copyright (c) 2018 Razeware LLC
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * Notwithstanding the foregoing, you may not use, copy, modify, merge, publish,
 * distribute, sublicense, create a derivative work, and/or sell copies of the
 * Software in any work that is designed, intended, or marketed for pedagogical or
 * instructional purposes related to programming, coding, application development,
 * or information technology.  Permission for such use, copying, modification,
 * merger, publication, distribution, sublicensing, creation of derivative works,
 * or sale is expressly withheld.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 *
 */

package com.raywenderlich.wewatch.view.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import com.google.android.material.snackbar.Snackbar
import com.raywenderlich.wewatch.R
import com.raywenderlich.wewatch.action
import com.raywenderlich.wewatch.snack
import kotlinx.android.synthetic.main.activity_add_movie.*
import kotlinx.android.synthetic.main.toolbar_view_custom_layout.*
import org.jetbrains.anko.intentFor

class AddMovieActivity : BaseActivity() {

  private val toolbar: Toolbar by lazy { toolbar_toolbar_view as Toolbar }


  override fun getToolbarInstance() = toolbar

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_add_movie)
  }

  fun goToSearchMovieActivity(view: View) {
    if (titleEditText.text.toString().isNotBlank()) {
      startActivity(intentFor<SearchMovieActivity>("title" to titleEditText.text.toString()))
    } else {
      showMessage("You must enter a title")
    }
  }

  fun showMessage(msg: String) {
    addLayout.snack((msg), Snackbar.LENGTH_LONG) {
      action(getString(R.string.ok)) {
      }
    }
  }
}
