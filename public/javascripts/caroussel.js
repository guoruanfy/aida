$(document).ready(function() {
    var carousselItems = $("#caroussel>div>dl");
    var bottomLayer = $("#caroussel>div");
    var buttons = $("#caroussel>dl>dd");
    var secondaryTexts = $("#caroussel>dl>dt");
    var animationDelayField = $("#caroussel>input");
    var animationDelay = (
        animationDelayField !=
            null && animationDelayField.length > 0 && animationDelayField[0].getAttribute("value") ?
            animationDelayField[0].getAttribute("value") * 1000 : 5000
        );
    var itemWidth = $(carousselItems[0]).width();
    var currentItem = 1;
    var intervalTimer;
    if (carousselItems == null || carousselItems.length == 0) {
        return;
    }
    bottomLayer.width(carousselItems.length * itemWidth);
    var animateFunction = function(index, Element) {
        var currentButton = Element;
        var currentIndex = index;
        var marginLeftC = -itemWidth * (index);
        bottomLayer.animate({marginLeft:marginLeftC});
        buttons.each(
            function(index, Element) {
                if (currentButton == Element) {
                    Element.className = "active";
                }
                else {
                    Element.className = "";
                }
            }
        )
        secondaryTexts.each(
            function(index, Element) {
                if (currentIndex == index) {
                    $(Element).show();
                } else {
                    $(Element).hide();
                }
            }
        )
    };
    var resetAnimationTimer = function(currentItemIndex) {
        if (intervalTimer) {
            clearInterval(intervalTimer);
        }
        currentItem = currentItemIndex;
        intervalTimer = setInterval(function() {
            animateFunction(currentItem, buttons[buttons.length - currentItem - 1]);
            currentItem = (currentItem + 1) % carousselItems.length;
        }, animationDelay);
    };
    carousselItems.each(function(index, Element) {
        $(Element).mouseover(function(event) {
            if (intervalTimer) {
                clearInterval(intervalTimer);
            }
        });
        $(Element).mouseout(function(event) {
            event.stopPropagation();
            resetAnimationTimer((index + 1) % carousselItems.length);
        });
    });

    buttons.each(function(index, Element) {
        $(Element).click(function(event) {
            resetAnimationTimer((buttons.length - index) % carousselItems.length);
            animateFunction(buttons.length - index - 1, Element);
        });
    });
    resetAnimationTimer(1);
});