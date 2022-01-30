package com.solvd.onlinestore.utils.lambdahomework;

import com.solvd.onlinestore.utils.lambdahomework.interfaces.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class CustomerInformation {
    private String customerFirstName;
    private String customerLastName;
    private float yearsWithSubscription;
    private String typeOfMembership;
    private boolean isDelinquent;
    private int playerRanking;
    private boolean subscribesToNewsletter;

    private static final Logger LOGGER = LogManager.getLogger(CustomerInformation.class);


    public CustomerInformation() {

    }

    public CustomerInformation(String customerFirstName, String customerLastName, float yearsWithSubscription, String typeOfMembership, boolean isDelinquent) {
        this.customerFirstName = customerFirstName;
        this.customerLastName = customerLastName;
        this.yearsWithSubscription = yearsWithSubscription;
        this.typeOfMembership = typeOfMembership;
        this.isDelinquent = isDelinquent;
    }

    public CustomerInformation(String customerFirstName, String customerLastName, float yearsWithSubscription, String typeOfMembership, boolean isDelinquent, int playerRanking) {
        this.customerFirstName = customerFirstName;
        this.customerLastName = customerLastName;
        this.yearsWithSubscription = yearsWithSubscription;
        this.typeOfMembership = typeOfMembership;
        this.isDelinquent = isDelinquent;
        this.playerRanking = playerRanking;
    }

    public CustomerInformation(String customerFirstName, String customerLastName, float yearsWithSubscription, String typeOfMembership, boolean isDelinquent, int playerRanking, boolean subscribesToNewsletter) {
        this.customerFirstName = customerFirstName;
        this.customerLastName = customerLastName;
        this.yearsWithSubscription = yearsWithSubscription;
        this.typeOfMembership = typeOfMembership;
        this.isDelinquent = isDelinquent;
        this.playerRanking = playerRanking;
        this.subscribesToNewsletter = subscribesToNewsletter;
    }

    public String getCustomerFirstName() {
        return customerFirstName;
    }

    public void setCustomerFirstName(String customerFirstName) {
        this.customerFirstName = customerFirstName;
    }

    public String getCustomerLastName() {
        return customerLastName;
    }

    public void setCustomerLastName(String customerLastName) {
        this.customerLastName = customerLastName;
    }

    public float getYearsWithSubscription() {
        return yearsWithSubscription;
    }

    public void setYearsWithSubscription(float yearsWithSubscription) {
        this.yearsWithSubscription = yearsWithSubscription;
    }

    public String getTypeOfMembership() {
        return typeOfMembership;
    }

    public void setTypeOfMembership(String typeOfMembership) {
        this.typeOfMembership = typeOfMembership;
    }

    public boolean isDelinquent() {
        return isDelinquent;
    }

    public void setDelinquent(boolean delinquent) {
        isDelinquent = delinquent;
    }

    public int getPlayerRanking() {
        return playerRanking;
    }

    public void setPlayerRanking(int playerRanking) {
        this.playerRanking = playerRanking;
    }

    public boolean isSubscribesToNewsletter() {
        return subscribesToNewsletter;
    }

    public void setSubscribesToNewsletter(boolean subscribesToNewsletter) {
        this.subscribesToNewsletter = subscribesToNewsletter;
    }
    public static List<CustomerInformation> getCustomersInformation(){
        return List.of(
                new CustomerInformation("Charlie", "Brown", 5, "Gold", false, 1950, true),
                new CustomerInformation("April","Bloom", 2, "Gold", false, 2050, true),
                new CustomerInformation("Aiden", "Smith", 8, "Silver", true, 2000, true),
                new CustomerInformation("Edgar", "Poe", 1, "Bronze",false, 1600, false),
                new CustomerInformation("Matthew","Stan", 0.5f, "Gold", true, 1400, true),
                new CustomerInformation("Rachel", "Borden", 12, "Silver", false, 1200, false)
        );
    }

    public static void generalAdvertisements() {

        IMembershipAdvertisement advertisement = () -> {
            LOGGER.info("Thinking of upgrading to Gold? You can do so right now at a 25% discount.");
        };

        advertisement.membershipsAdvertised();

        ISpecialOffers currentOffers = () -> {
            LOGGER.info("This months exclusive offers:");
            LOGGER.info("If you are a pre-existing member you may be eligible for a reduced membership rate.");
            LOGGER.info("Free complimentary chess boards for all members celebrating their 1 year subscription to our sites store.");
        };

        currentOffers.currentPromotionalOffer();

    }

    public static void greetingsToCustomers() {
        IWelcomeCustomerMessage welcomeMessage = () -> {
            LOGGER.info("Welcome to The Chess Shop! We are very excited to have you as our newest member.");
        };

        welcomeMessage.welcome();
    }

    public static void customerTerminations() {
        ITerminationMessage lastMessage = () -> {
            LOGGER.info("We are so sorry to see you go. We wish you nothing but the best on your future endeavors.");
        };

        lastMessage.membershipEndedMessage();
    }

    public static void financialMatters() {
        IDelinquencyMessage latePayment = () -> {
            LOGGER.info("If you are receiving this message you are delinquent on one or more payments.");
            LOGGER.info("Please contact customer support immediately to insure there is no disruption in your service.");
        };
        latePayment.delinquencyNotice();
    }

    public static void rankedPlayerCustomers() {
        for (CustomerInformation customerInformation : getCustomersInformation()) {
            IRankedChessPlayerDiscount rankedChessPlayerDiscount = () -> {
                if (customerInformation.playerRanking >= 2000) {
                    LOGGER.info(customerInformation.customerFirstName + " Since you have a rating at or above the 2000 level enjoy a monthly 50% discount on our store website");
                }
            };
            rankedChessPlayerDiscount.isRankedPlayer();
        }
    }

    public static void customersWithoutNewsLetters() {
        for (CustomerInformation customerInformation : getCustomersInformation()) {
             INewsletterRecipient currentlyNotSubscribed = () -> {
                if (!customerInformation.subscribesToNewsletter) {
                    LOGGER.info("Dear " + customerInformation.customerFirstName + ", all of our 2000 rated players subscribe and live by our newsletter.");
                    LOGGER.info("Its at no cost to you for a complete year if you act fast.");
                }
            };

            currentlyNotSubscribed.isInterestedInNewsLetter();
        }
    }





    /*public static void main(String[] args) {
        generalAdvertisements();
        greetingsToCustomers();
        customerTerminations();
        financialMatters();
        rankedPlayerCustomers();
        customersWithoutNewsLetters();
    }
     */

    @Override
    public String toString() {
        return "CustomerSubscriptions{" +
                "customerFirstName='" + customerFirstName + '\'' +
                ", customerLastName='" + customerLastName + '\'' +
                ", yearsWithSubscription=" + yearsWithSubscription +
                ", typeOfMembership='" + typeOfMembership + '\'' +
                ", delinquencies=" + isDelinquent +
                '}';
    }
}
