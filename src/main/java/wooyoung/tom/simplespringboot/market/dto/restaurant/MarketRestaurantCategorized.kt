package wooyoung.tom.simplespringboot.market.dto.restaurant

data class MarketRestaurantCategorized(
    val category: String,
    val body: List<CategorizedRestaurantItem>
)
