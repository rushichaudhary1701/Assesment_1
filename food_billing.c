#include <stdio.h>

int main() {
    int choice, quantity;
    char more;
    float total = 0;

    printf("********** Welcome to Food Billing System **********\n");

    do {
        // Display Menu
        printf("\n---- Menu ----\n");
        printf("1. Pizza       - Rs. 200\n");
        printf("2. Burger      - Rs. 120\n");
        printf("3. Sandwich    - Rs. 100\n");
        printf("4. Pasta       - Rs. 150\n");
        printf("5. Cold Drink  - Rs. 50\n");

        // Take order
        printf("\nEnter your choice (1-5): ");
        scanf("%d", &choice);

        printf("Enter quantity: ");
        scanf("%d", &quantity);

        // Calculate bill based on choice
        switch(choice) {
            case 1: total += 200 * quantity;
                    printf("Added %d Pizza(s)\n", quantity);
                    break;
            case 2: total += 120 * quantity;
                    printf("Added %d Burger(s)\n", quantity);
                    break;
            case 3: total += 100 * quantity;
                    printf("Added %d Sandwich(es)\n", quantity);
                    break;
            case 4: total += 150 * quantity;
                    printf("Added %d Pasta(s)\n", quantity);
                    break;
            case 5: total += 50 * quantity;
                    printf("Added %d Cold Drink(s)\n", quantity);
                    break;
            default: printf("Invalid choice!\n");
        }

        // Ask if user wants more
        printf("\nDo you want to order more? (y/n): ");
        scanf(" %c", &more);

    } while(more == 'y' || more == 'Y');

    // Final Bill
    printf("\n********** Final Bill **********\n");
    printf("Total Amount = Rs. %.2f\n", total);
    printf("********** Thank You **********\n");

    return 0;
}
