package internet.store.dao.impl;

import internet.store.dao.ShopCartDao;
import internet.store.db.Storage;
import internet.store.lib.Dao;
import internet.store.model.ShoppingCart;
import java.util.Optional;
import java.util.stream.IntStream;

@Dao
public class ShopCartDaoImpl implements ShopCartDao {

    @Override
    public ShoppingCart create(ShoppingCart shoppingCart) {
        Storage.addCart(shoppingCart);
        return shoppingCart;
    }

    @Override
    public Optional<ShoppingCart> getByUserId(Long userID) {
        return Storage.shopCarts.stream()
                .filter(s -> s.getUserId().equals(userID))
                .findFirst();
    }

    @Override
    public ShoppingCart update(ShoppingCart shoppingCart) {
        IntStream.range(0, Storage.shopCarts.size())
                .filter(p -> shoppingCart.getCartId()
                        .equals(Storage.shopCarts.get(p).getCartId()))
                .forEach(p -> Storage.shopCarts.set(p, shoppingCart));
        return shoppingCart;
    }

    @Override
    public boolean deleteCart(ShoppingCart shoppingCart) {
        return Storage.shopCarts
                .removeIf(c -> c.getCartId().equals(shoppingCart.getCartId()));
    }
}