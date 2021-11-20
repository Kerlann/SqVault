const {
  BrowserRouter,
  Switch,
  Router,
  Route,
  Link,
  NavLink
} = ReactRouterDOM;

class Container extends React.Component {
  constructor(props) {
    super(props);
  }

  render() {
    return (
      <Switch>
        <Home />
        <Route path="/" exact component={Dashbord} />
        <Route component={Dashbord} />
      </Switch>
    );
  }
}
