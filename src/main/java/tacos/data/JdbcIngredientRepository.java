package tacos.data;

import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import tacos.Ingredient;

@Repository
@AllArgsConstructor
public class JdbcIngredientRepository implements IngredientRepository{

    private JdbcTemplate jdbcTemplate;

    @Override
    public Iterable<Ingredient> findAll() {
        return null;
    }

    @Override
    public Optional<Ingredient> findById(final String id) {
        return Optional.empty();
    }

    @Override
    public Ingredient save(final Ingredient ingredient) {
        return null;
    }
}
