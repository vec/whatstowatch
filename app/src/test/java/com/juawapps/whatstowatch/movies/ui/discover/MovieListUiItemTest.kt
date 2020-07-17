package com.juawapps.whatstowatch.movies.ui.discover

import com.juawapps.whatstowatch.R
import com.juawapps.whatstowatch.fixtures.MovieListItemFixture
import com.juawapps.whatstowatch.fixtures.MovieListUiItemFixture
import org.junit.Assert.assertEquals
import org.junit.Test

class MovieListUiItemTest {

    val movieListUiItemFixture = MovieListUiItemFixture()
    val movieListItemFixture = MovieListItemFixture()

    @Test
    fun `create() when given default fixture it maps correctly`() {
        assertEquals(
            movieListUiItemFixture(),
            MovieListUiItem.create(movieListItemFixture())
        )
    }

    @Test
    fun `create() when voteAverage is less than 07 it gets meh voteColorAttr`() {
        val movieListItem05 = movieListItemFixture {
            copy(voteAverage = 0.5f)
        }

        val movieListUiItemMeh = movieListUiItemFixture {
            copy(
                voteAverage = "0.5",
                voteColorAttr = R.attr.mehColor
            )
        }

        assertEquals(
            movieListUiItemMeh,
            MovieListUiItem.create(movieListItem05)
        )
    }

    @Test
    fun `create() when voteAverage is greater than 07 it gets positive voteColorAttr`() {
        val movieListItem05 = movieListItemFixture {
            copy(voteAverage = 0.8f)
        }

        val movieListUiItemPositive = movieListUiItemFixture {
            copy(
                voteAverage = "0.8",
                voteColorAttr = R.attr.positiveColor
            )
        }

        assertEquals(
            movieListUiItemPositive,
            MovieListUiItem.create(movieListItem05)
        )
    }
}