

import artspaceapp.composeapp.generated.resources.Res
import artspaceapp.composeapp.generated.resources.author_1
import artspaceapp.composeapp.generated.resources.author_2
import artspaceapp.composeapp.generated.resources.author_3
import artspaceapp.composeapp.generated.resources.author_4
import artspaceapp.composeapp.generated.resources.author_5
import artspaceapp.composeapp.generated.resources.author_6
import artspaceapp.composeapp.generated.resources.emerald_valley_serenade
import artspaceapp.composeapp.generated.resources.floating_floral_beauty
import artspaceapp.composeapp.generated.resources.golden_lake_reflections
import artspaceapp.composeapp.generated.resources.image_1
import artspaceapp.composeapp.generated.resources.image_2
import artspaceapp.composeapp.generated.resources.image_3
import artspaceapp.composeapp.generated.resources.image_4
import artspaceapp.composeapp.generated.resources.image_5
import artspaceapp.composeapp.generated.resources.image_6
import artspaceapp.composeapp.generated.resources.painted_meadow_dreams
import artspaceapp.composeapp.generated.resources.sunlit_sanctuary
import artspaceapp.composeapp.generated.resources.whispers_of_the_savannah_grove
import artspaceapp.composeapp.generated.resources.year_1
import artspaceapp.composeapp.generated.resources.year_2
import artspaceapp.composeapp.generated.resources.year_3
import artspaceapp.composeapp.generated.resources.year_4
import artspaceapp.composeapp.generated.resources.year_5
import artspaceapp.composeapp.generated.resources.year_6
import org.example.artspaceapp.returnAuthor
import org.example.artspaceapp.returnImage
import org.example.artspaceapp.returnTitle
import org.example.artspaceapp.returnYear
import kotlin.test.Test
import kotlin.test.assertEquals

// For local or unit test
class UnitAppKtTest {
    // For testing the images
    @Test
    fun testReturnImage() {
        assertEquals(expected = returnImage(imageNumber = 1), actual = Res.drawable.emerald_valley_serenade)
        assertEquals(expected = returnImage(imageNumber = 2), actual = Res.drawable.floating_floral_beauty)
        assertEquals(expected = returnImage(imageNumber = 3), actual = Res.drawable.golden_lake_reflections)
        assertEquals(expected = returnImage(imageNumber = 4), actual = Res.drawable.painted_meadow_dreams)
        assertEquals(expected = returnImage(imageNumber = 5), actual = Res.drawable.sunlit_sanctuary)
        assertEquals(expected = returnImage(imageNumber = 6), actual = Res.drawable.whispers_of_the_savannah_grove)
        assertEquals(expected = returnImage(imageNumber = 7), actual = Res.drawable.emerald_valley_serenade)
    }
    // For testing the titles
    @Test
    fun testReturnTitle() {
        assertEquals(expected = returnTitle(imageNumber = 1), actual = Res.string.image_1)
        assertEquals(expected = returnTitle(imageNumber = 2), actual = Res.string.image_2)
        assertEquals(expected = returnTitle(imageNumber = 3), actual = Res.string.image_3)
        assertEquals(expected = returnTitle(imageNumber = 4), actual = Res.string.image_4)
        assertEquals(expected = returnTitle(imageNumber = 5), actual = Res.string.image_5)
        assertEquals(expected = returnTitle(imageNumber = 6), actual = Res.string.image_6)
        assertEquals(expected = returnTitle(imageNumber = 7), actual = Res.string.image_1)
    }
    // For testing the painter name
    @Test
    fun testReturnAuthor() {
        assertEquals(expected = returnAuthor(imageNumber = 1), actual = Res.string.author_1)
        assertEquals(expected = returnAuthor(imageNumber = 2), actual = Res.string.author_2)
        assertEquals(expected = returnAuthor(imageNumber = 3), actual = Res.string.author_3)
        assertEquals(expected = returnAuthor(imageNumber = 4), actual = Res.string.author_4)
        assertEquals(expected = returnAuthor(imageNumber = 5), actual = Res.string.author_5)
        assertEquals(expected = returnAuthor(imageNumber = 6), actual = Res.string.author_6)
        assertEquals(expected = returnAuthor(imageNumber = 7), actual = Res.string.author_1)
    }
    // For testing the year
    @Test
    fun testReturnYear() {
        assertEquals(expected = returnYear(imageNumber = 1), actual = Res.string.year_1)
        assertEquals(expected = returnYear(imageNumber = 2), actual = Res.string.year_2)
        assertEquals(expected = returnYear(imageNumber = 3), actual = Res.string.year_3)
        assertEquals(expected = returnYear(imageNumber = 4), actual = Res.string.year_4)
        assertEquals(expected = returnYear(imageNumber = 5), actual = Res.string.year_5)
        assertEquals(expected = returnYear(imageNumber = 6), actual = Res.string.year_6)
        assertEquals(expected = returnYear(imageNumber = 7), actual = Res.string.year_1)
    }
}
