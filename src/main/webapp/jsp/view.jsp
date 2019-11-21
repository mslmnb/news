<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<head>
    <title>News Management</title>
    <link rel="stylesheet" href="../resources/css/style.css">
</head>
<body>

</body>

<div id="react-app"></div>


<script src="https://cdn.jsdelivr.net/react/0.14.0-rc1/react.js"></script>
<script src="https://cdn.jsdelivr.net/react/0.14.0-rc1/react-dom.js"></script>

<script>
    var xmlhttp = new XMLHttpRequest();
    var url = "http://localhost:8083/news/list/${param.id}";

    xmlhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            myFunction(this.responseText);
        }
    }
    xmlhttp.open("GET", url, true);
    xmlhttp.send();

    function myFunction(response) {
        var news = JSON.parse(response);
        /*
         * Components
         */
        var NewsMenu = React.createClass({
            render: function () {
                return (
                    React.createElement('div', {className: "width20 box-col"},
                        React.createElement('ul', {className: "box"},
                            React.createElement('li', {},
                                React.createElement('a', {href: "#"}, "News List")
                            ),
                            React.createElement('li', {},
                                React.createElement('a', {href: "#"}, "Add News")
                            )
                        )
                    )
                )
            }
        })

        var NewsItem = React.createClass({
            propTypes: {
                id: React.PropTypes.number.isRequired,
                date: React.PropTypes.string.isRequired,
                title: React.PropTypes.string.isRequired,
                brief: React.PropTypes.string.isRequired
            },
            render: function () {
                return (
                    React.createElement('div', {},
                        React.createElement('div', {className: "box-row"},
                            React.createElement('div', {className: "box width20"}, "News Title"),
                            React.createElement('div', {className: "box width80"}, this.props.title)
                        ),
                        React.createElement('div', {className: "box-row"},
                            React.createElement('div', {className: "box width20"}, "News Date"),
                            React.createElement('div', {className: "box width80"}, this.props.date)
                        ),
                        React.createElement('div', {className: "box-row"},
                            React.createElement('div', {className: "box width20"}, "Brief"),
                            React.createElement('div', {className: "box width80"}, this.props.brief)
                        ),
                        React.createElement('div', {className: "box-row"},
                            React.createElement('div', {className: "width100 button_panel"},
                                React.createElement('a', {className: "button", href: "#"}, "EDIT"),
                                React.createElement('a', {className: "button", href: "#"}, "DELETE")
                            )
                        )
                    )
                )
            }
        })

        var NewsView = React.createClass({
            propTypes: {
                news: React.PropTypes.array.isRequired
            },
            render: function () {
                var newsItemElement = React.createElement(NewsItem, news)

                return (
                    React.createElement('div', {},
                        React.createElement('h2', {}, "News Management"),
                        React.createElement('div', {className: "box-table"},
                            React.createElement(NewsMenu),
                            React.createElement('div', {className: "width80 box-col"}, newsItemElement)
                        )
                    )
                )
            }
        })
        /*
         * Entry point
         */
        ReactDOM.render(
            React.createElement(NewsView, {
                news: news   // Json data
            }),
            document.getElementById('react-app')
        )
    }
</script>
</html>
