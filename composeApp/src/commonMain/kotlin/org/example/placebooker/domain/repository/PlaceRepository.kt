package org.example.placebooker.domain.repository

import kotlinx.coroutines.flow.*
import org.example.placebooker.domain.models.*

class PlaceRepository {
    fun getPlaces(): Flow<List<Place>> = flowOf(
        listOf(
            Place("1", "Уютный Ресторан", "Пойковский вкус", PlaceCategory.RESTAURANT, 4.8, 3, GeoPoint(60.0, 70.0), "ул. Мира, 10", "https://picsum.photos/400/200?random=1"),
            Place("2", "Центральный Парк", "Твоя прогулка", PlaceCategory.PARK, 4.5, 1, GeoPoint(60.1, 70.2), "Парковая зона", "https://picsum.photos/400/200?random=2"),
            Place("3", "Кофе и Код", "Энергия кода", PlaceCategory.COFFEE_SHOP, 4.
# 1. Заходим в проект
cd /storage/emulated/0/Documents/GeoBlinker_WORKSPACE/PLACE_OFFICIAL/

# 2. Обновляем карточку места (добавляем поддержку фото)
cat <<'EOF' > composeApp/src/commonMain/kotlin/org/example/placebooker/ui/components/PlaceCard.kt
package org.example.placebooker.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.example.placebooker.domain.models.Place
import org.example.placebooker.core.resources.Res

@Composable
fun PlaceCard(place: Place, onClick: () -> Unit) {
    ElevatedCard(onClick = onClick, modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)) {
        Column {
            // Заглушка под фото (пока Coil не подключен в build.gradle, рисуем цветной бокс)
            Surface(modifier = Modifier.fillMaxWidth().height(150.dp), color = MaterialTheme.colorScheme.primaryContainer) {
                Box(contentAlignment = androidx.compose.ui.Alignment.Center) {
                    Text("Фото: ${place.name}", style = MaterialTheme.typography.labelSmall)
                }
            }
            Column(modifier = Modifier.padding(16.dp)) {
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                    Text(text = place.name, style = MaterialTheme.typography.titleLarge)
                    Text(text = "⭐ ${place.rating}", style = MaterialTheme.typography.bodyMedium)
                }
                Text(text = place.category.name, color = MaterialTheme.colorScheme.primary)
                Text(text = place.address, style = MaterialTheme.typography.bodySmall)
                Button(onClick = onClick, modifier = Modifier.align(androidx.compose.ui.Alignment.End)) {
                    Text(Res.Strings.BOOK_NOW)
                }
            }
        }
    }
}
