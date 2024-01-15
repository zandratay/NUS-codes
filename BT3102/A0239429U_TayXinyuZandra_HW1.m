% stuID1 = A0239429U;
% stuName1 = Tay Xinyu, Zandra;
% stuID2 = A0229830A;
% stuName2 = Lucas Wee Song Wen;

function [O] = A0239429U_TayXinyuZandra_HW1(~)

    %%%%%%%%%% Problem 1
    % Problem1a();
    % Problem1b();
    % Problem1c();
    % Problem1d();
    % Problem1e();
    
    %%%%%%%%%% Problem 2
    eps1 = 10^(-8);
    eps2 = 10^(-12);
    x1 = [-1.2,1]';
    x2 = [1.2,1.2]';
    % Problem2(eps1, x1);
    % Problem2(eps1, x2);
    % Problem2(eps2, x1);
    % Problem2(eps2, x2);
    
    %%%%%%%%%% Problem 3
    eps3 = 10^(-8);
    n3 = 10000;
    % Problem3(n3, eps3);
    
    %%%%%%%%%% Problem 4
    lambda1 = 100;
    lambda2 = 1;
    n4 = 100;
    eps4 = 10^(-11);
    % Problem4(n4,eps4,lambda1);
    % Problem4(n4,eps4,lambda2);

end

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%%%%%%%%%%%%%%%% Problem 1 %%%%%%%%%%%%%%%%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% Q1A
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

function [] = Problem1a()
    syms x1 x2

    % Value of function
    f = x1*exp(-1 * (x1^2 + x2^2)/2);

    % Compute the gradient
    gradient_f = gradient(f, [x1, x2]);  

    % Compute the Hessian
    hessian_f = hessian(f, [x1, x2]);

    disp(f)
    disp(gradient_f)
    disp(hessian_f)
end

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%Q1B
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

function [] = Problem1b()
    [x1, x2] = meshgrid(linspace(-3, 3, 100), linspace(-3, 3, 100));
    F = x1.*exp(-1 * (x1.^2 + x2.^2)/2);
    figure;
    surf(x1, x2, F);
end

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%Q1C
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
function [] = Problem1c()
    syms x1 x2;
    f = x1*exp(-1 * (x1^2 + x2^2)/2);
    
    % point x bar
    x1_bar = -1;
    x2_bar = 1/2;
    
    % compute first and second derivatives
    dfdx_first = diff(f, x1);
    dfdy_first = diff(f, x2);
    dfdx_second = diff(dfdx_first, x1);
    dfdy_second = diff(dfdy_first, x2);
    mixed_partial_derivative = diff(dfdx_first, x2);
    
    % Calculate the values of the function and its derivatives at point (x1_bar,
    % x2_bar)
    f_val = subs(f, {x1, x2}, {x1_bar, x2_bar});
    dfdx_first_val = subs(dfdx_first, {x1, x2}, {x1_bar, x2_bar});
    dfdy_first_val = subs(dfdy_first, {x1, x2}, {x1_bar, x2_bar});
    dfdx_second_val = subs(dfdx_second, {x1, x2}, {x1_bar, x2_bar});
    dfdy_second_val = subs(dfdy_second, {x1, x2}, {x1_bar, x2_bar});
    mixed_partial_derivative_val = subs(mixed_partial_derivative, {x1, x2}, {x1_bar, x2_bar});
    
    % Applying formula for 2nd order Taylor approx
    taylor_2nd_approx = f_val + dfdx_first_val * (x1 - x1_bar) + dfdy_first_val * (x2 - x2_bar) ...
        + 0.5 * dfdx_second_val * (x1 - x1_bar)^2 + 0.5 * dfdy_second_val * (x2 - x2_bar) ^2 ...
        + mixed_partial_derivative_val * (x1 - x1_bar) * (x2 - x2_bar);
    
    disp(taylor_2nd_approx)
end

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%Q1D
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

function [] = Problem1d()
    syms x1 x2; 
    f = x1*exp(-1 * (x1^2 + x2^2)/2); 
    % point x bar 
    x1_bar = -1; 
    x2_bar = 1/2; 
    % compute first and second derivatives 
    dfdx_first = diff(f, x1); 
    dfdy_first = diff(f, x2); 
    dfdx_second = diff(dfdx_first, x1); 
    dfdy_second = diff(dfdy_first, x2); 
    mixed_partial_derivative = diff(dfdx_first, x2); 
    % Calculate the values of the function and its derivatives at point (x_bar, 
    % y_bar) 
    f_val = subs(f, {x1, x2}, {x1_bar, x2_bar}); 
    dfdx_first_val = subs(dfdx_first, {x1, x2}, {x1_bar, x2_bar}); 
    dfdy_first_val = subs(dfdy_first, {x1, x2}, {x1_bar, x2_bar}); 
    dfdx_second_val = subs(dfdx_second, {x1, x2}, {x1_bar, x2_bar}); 
    dfdy_second_val = subs(dfdy_second, {x1, x2}, {x1_bar, x2_bar}); 
    mixed_partial_derivative_val = subs(mixed_partial_derivative, {x1, x2}, {x1_bar, x2_bar}); 
    % Applying formula for 2nd order Taylor approx 
    taylor_2nd_approx = f_val + dfdx_first_val * (x1 - x1_bar) + dfdy_first_val * (x2 - x2_bar) ... 
    + 0.5 * dfdx_second_val * (x1 - x1_bar)^2 + 0.5 * dfdy_second_val * (x2 - x2_bar) ^2 ... 
    + mixed_partial_derivative_val * (x1 - x1_bar) * (x2 - x2_bar);

    % Create a mesh grid 
    [X1, X2] = meshgrid(-1.5:0.1:-0.5, -1:0.1:1); 
     
    % Evaluate the functions on the grid 
    f_eval = double(subs(f, {x1, x2}, {X1, X2})); 
    taylor_eval = double(subs(taylor_2nd_approx, {x1, x2}, {X1, X2})); 
     
    % Create a 3D surface plot 
    figure; 
    surf(X1, X2, f_eval, 'DisplayName', 'f(x1, x2)'); 
    hold on; 
    surf(X1, X2, taylor_eval, 'DisplayName', 'Taylor Approximation'); 
    xlabel('x1'); 
    ylabel('x2'); 
    zlabel('Function Value'); 
    title('Original Function f(x1, x2) and Second-Order Taylor Approximation'); 
    legend('Location', 'Northwest'); 
    grid on; 
    hold off;
end

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%Q1E
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
function [] = Problem1e()
    syms x1 x2;
    f = x1*exp(-1 * (x1^2 + x2^2)/2);
    dfdx_first = diff(f, x1);
    dfdy_first = diff(f, x2);
    stationary_points = solve([dfdx_first == 0, dfdy_first == 0], [x1, x2]);
    
    disp(stationary_points.x1(1)) % -1
    disp(stationary_points.x2(1)) % 0
    disp(stationary_points.x1(2)) % 1
    disp(stationary_points.x2(2)) % 0
    
    % using your knowledge of the first and second order optimality conditions, 
    % determine if they are minimizers or maximizers, or only saddle points?
    stat_x_1 = -1;
    stat_y_1 = 0;
    stat_x_2 = 1;
    stat_y_2 = 0;
    
    dfdx_second = diff(dfdx_first, x1);
    
    subs(dfdx_second, {x1, x2}, {stat_x_1, stat_y_1})
    subs(dfdx_second, {x1, x2}, {stat_x_2, stat_y_2}) 
end

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%%%%%%%%%%%%%%%% Problem 2 %%%%%%%%%%%%%%%%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

function [] = Problem2(eps, x)
    SteepestDescentWithArmijoBackTracking(x, eps);
    NewtonsWithArmijoBackTracking(x, eps);
end

function [y] = value_of_objective_function(x)
x1 = x(1);
x2 = x(2);
y = 100*(x2 - x1^2)^2 + (1 - x1)^2;
end

function [y] = Gradient_of_objective_function(x)
x1 = x(1);
x2 = x(2);
y = [2*x1 - 400*x1*(- x1^2 + x2) - 2 ;
    - 200*x1^2 + 200*x2];
end

function [y] = Hessian_of_objective_function(x)
x1 = x(1);
x2 = x(2);
y = [1200*x1^2 - 400*x2 + 2, -400*x1;
     -400*x1, 200];
end

% Steepest Descent
function[] = SteepestDescentWithArmijoBackTracking(starting_point, epsilon)
c = 10^(-4); 
rho = 0.5;             
a0 = 1;

W_hist = zeros(2,1000); % Store the values of the decision vector in each iteration
Count = 0; % track the total number of iterations
Gap = 1;   % Initial distance of the gradient to 0

while Gap>epsilon
   Count = Count + 1; 
   W_hist(:,Count) = starting_point;
   Grad = Gradient_of_objective_function(starting_point);
   p = -Grad;   
   %%%%%%%%%%%% Armijo backtracking step
   a = a0;
   Wp = starting_point+a*p; % potential point in the next iteration with step size alpha (which will be determined after the while loop below)
   while value_of_objective_function(Wp)>= value_of_objective_function(starting_point)+c*a*p'*Gradient_of_objective_function(starting_point)
      a = rho*a; 
      Wp = starting_point+a*p;
   end
   %%%%%%%%%%%
   starting_point = starting_point + a*p;
   Gap = norm(Gradient_of_objective_function(starting_point));
end

opt_x1 = W_hist(1, end);
opt_x2 = W_hist(2, end);
opt_function_value = value_of_objective_function([opt_x1, opt_x2]);

sprintf('Number of iterations: %d', Count)
sprintf('Optimal solution of x1: %d', opt_x1)
sprintf('Optimal solution of x2: %d', opt_x2)
sprintf('Optimal function value: %d', opt_function_value)
end

% Newton's method
function[] = NewtonsWithArmijoBackTracking(starting_point, epsilon)
    Count = 0; % track the total number of iterations

    while true
        f = value_of_objective_function(starting_point);
        df = Gradient_of_objective_function(starting_point); % 1st derivative
        df2 = Hessian_of_objective_function(starting_point); % 2nd derivative
    
        c = 10^(-4); 
        rho = 0.5;             
        a = 1;
    
        direction = -(df2 \ df);
       
        %%%%%%%%%%%% Armijo backtracking step
        while value_of_objective_function([starting_point(1) + a * direction(1), starting_point(2) + a * direction(2)]) > f + c * a * df' * direction
           a = rho*a; 
        end
        %%%%%%%%%%%
        % Update the current point
        starting_point = starting_point + a * direction;
    
        % Check for convergence
        if norm(df) < epsilon
             break;
        end
        Count = Count + 1; 
    end

    sprintf('Number of iterations: %d', Count)
    disp(starting_point)
    sprintf('Optimal function value: %d', value_of_objective_function(starting_point))
    
end

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%%%%%%%%%%%%%%%% Problem 3 %%%%%%%%%%%%%%%%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
function [] = Problem3(n, eps0)
    SteepestDescentWithWolfe(n, eps0) 
    BFGSWithWolfe2(n, eps0)
end

function f = value_of_objective_function_q3(x, n)
    temp = 0;
    exp_x1 = exp(x(1));
    
    % Compute the function value
    term1 = (exp_x1 - 1) / (exp_x1 + 1);
    term2 = exp(-x(1)) / 10;
    
    for i = 2:n
        temp = temp + (x(i)-1)^4;
    end

    f = term1 + term2 + temp;
end

function g = Gradient_of_objective_function_q3(x, n)
    exp_x1 = exp(x(1));
    term1 = (2*exp_x1) / (exp_x1 + 1)^2;
    term2 = -exp(-x(1)) / 10;
    
    g = zeros(n, 1);
    g(1) = term1 + term2;
    
    for i = 2:n
        g(i) = 4 * (x(i) - 1)^3;
    end
end

% Steepest Descent with Wolfe
function[FV,FW] = SteepestDescentWithWolfe(n, eps0) 
    c1 = 10^(-4); 
    c2 = 0.9;
    e_skip = eps0;
    a0 = 1;
    K = 50000; % total number of iterations 
    W = zeros(n, 1);
    W(1) = 1;
    W_hist = zeros(n,K); % Store the values of the decision vector in each iteration
    I = eye(length(W));   
    H = I;
    Count = 0; % track the total number of iterations
    Gap = 1;   % As long as this is > eps0 (to execute the while loop for the 1st time), it will be fine.
    
    while Gap>eps0 && Count<K
       Count = Count + 1; 
       W_hist(:, Count) = W;
       temp1 = Gradient_of_objective_function_q3(W, n);
       p = -temp1; 
       Wc = W; 
       % Wolfe condition part
        alpha = a0;
        alpha_L = 0;
        alpha_U = realmax;
        while true   % Wolfe line search criterion
              Wp = W + alpha*p;
              if value_of_objective_function_q3(Wp, n) > value_of_objective_function_q3(W, n) + c1*alpha*p'*Gradient_of_objective_function_q3(W, n)     
                 alpha_U = alpha;
              else
                 if p'*Gradient_of_objective_function_q3(Wp, n) < c2*p'*Gradient_of_objective_function_q3(W, n)
                    alpha_L = alpha;
                 else
                    break
                 end
              end
              if alpha_U < realmax
                 alpha = (alpha_L + alpha_U)/2;
              else
                 alpha = 2*alpha_L;
              end     
        end
    % end
    %%%%%%%%%%%
        W = W + alpha*p; % find the next point
        s = W - Wc;  
        temp2 = Gradient_of_objective_function_q3(W, n);
        y = temp2 - temp1; 
        if s'*y >= e_skip*norm(s)*norm(y)
           rho = 1/(y'*s);
           H = (I-rho*s*y')*H*(I-rho*y*s')+rho*(s*s');
        end
        Gap = norm(temp2);
    end
    FW = W;
    FV = value_of_objective_function_q3(W, n);

    sprintf('Number of iters: %d', Count)
    sprintf('Optimal values: %d', FW)
    sprintf('Optimal function value: %d', FV)

end

% BFGS with Wolfe
function[FV,FW] = BFGSWithWolfe2(n, eps0)
    c1 = 10^(-4); 
    c2 = 0.9;
    e_skip = 10^(-8); % check if y' times s is large enough
    a0 = 1;
    K = 50000; % total number of iterations 
    % eps0 = 10^(-8);
    
    W = zeros(n, 1);
    W(1) = 1;
    
    W_hist = zeros(n, K); % Store the values of the decision vector in each iteration
    I = eye(length(W));   
    H = I;
    Count = 0; % track the total number of iterations
    Gap = 1;

    while Gap>eps0 && Count<K
       Count = Count + 1; 
       W_hist(:, Count) = W;
       temp1 = Gradient_of_objective_function_q3(W, n);
       p = -H * temp1; 
       Wc = W;               % store the current point W   
       %%%%%%%%%%%% Wolfe
   alpha = a0;
   alpha_L = 0;
   alpha_U = realmax;
   while true   % Wolfe line search criterion
         Wp = W + alpha*p;
         if value_of_objective_function_q3(Wp, n)> value_of_objective_function_q3(W, n)+c1*alpha*p'*Gradient_of_objective_function_q3(W, n)     
            alpha_U = alpha;
         else
            if p'*Gradient_of_objective_function_q3(Wp, n) < c2*p'*Gradient_of_objective_function_q3(W, n)
               alpha_L = alpha;
            else
               break
            end
         end
         if alpha_U < realmax
            alpha = (alpha_L + alpha_U)/2;
         else
            alpha = 2*alpha_L;
         end     
         
   end
   %%%%%%%%%%%
   W = W + alpha*p; % find the next point
   s = W - Wc;  
   temp2 = Gradient_of_objective_function_q3(W, n);
   y = temp2 - temp1; 
   if s'*y >= e_skip*norm(s)*norm(y)
      rho = 1/(y'*s);
      H = (I-rho*s*y')*H*(I-rho*y*s')+rho*(s*s');
   end
   Gap = norm(temp2);

    end
    FW = W;
    FV = value_of_objective_function_q3(W, n);

    sprintf('Number of iters: %d', Count)
    sprintf('Optimal values: %d', FW)
    sprintf('Optimal function value: %d', FV)
end

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%%%%%%%%%%%%%%%% Problem 4 %%%%%%%%%%%%%%%%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
function[] = Problem4(n,epsilon,lambda)
    c1 = 10^(-4);
    c2 = 0.9;
    e_skip = epsilon;

    % Initialise vars for steepest descent
    a0 = 1;
    amin = 10^(-12);
    K = 50000; % Total number of iterations
    W = -ones(n,1);
    W_hist = zeros(n, K); % Store the values of the decision vector in each iteration
    I = eye(length(W));
    H = I;
    counter= 0; % Track the total number of iterations
    Gap = 1;
    while Gap>epsilon && counter<K
        counter= counter + 1;
        W_hist(:,counter) = W;
        temp1 = ext_rosenbrock_grad(W,lambda);
        p = -temp1; % the direction for the current point
        Wc = W; % store the current point W
        %%%%%%%%%%%% Wolfe
        alpha = a0;
        alpha_L = 0;
        alpha_U = realmax;
        while true % Wolfe line search criterion
            Wp = W + alpha*p;
            if ext_rosenbrock_val(Wp, lambda) > ext_rosenbrock_val(W, lambda) +c1*alpha*p'*ext_rosenbrock_grad(W, lambda);
                alpha_U = alpha;
            else
                if p'*ext_rosenbrock_grad(Wp, lambda) < c2*p'*ext_rosenbrock_grad(W, lambda)
                    alpha_L = alpha;
                else
                    break
                end
            end
            if alpha_U < realmax
                alpha = (alpha_L + alpha_U)/2;
            else
                alpha = 2*alpha_L;
            end
            if alpha<amin
                alpha = amin;
                Wp = W+alpha*p;
                if ext_rosenbrock_val(Wp, lambda) <= ext_rosenbrock_val(W, lambda)
                    break;
                else
                    error('The minimum step size does not produce a descent step. Consider other strategies.');
                end
            end
        end
        %%%%%%%%%%%
        W = W + alpha*p; % find the next point
        s = W - Wc;
        temp2 = ext_rosenbrock_grad(W, lambda);
        y = temp2 - temp1;
        if s'*y >= e_skip*norm(s)*norm(y)
            rho = 1/(y'*s);
            H = (I-rho*s*y')*H*(I-rho*y*s')+rho*(s*s');
        end
        Gap = norm(temp2);
    end
    num_iterations_steepest = counter
    fw_steepest = W
    fv_steepest = ext_rosenbrock_val(W, lambda)
    
    % re-initialise variables for BFGS
    a0 = 1;
    amin = 10^(-12);
    K = 50000; % Total number of iterations
    W = -ones(n,1);
    W_hist = zeros(n, K); % Store the values of the decision vector in each iteration
    I = eye(length(W));
    H = I;
    counter= 0; % Track the total number of iterations
    Gap = 1;
    while Gap>epsilon && counter<K
        counter= counter + 1;
        W_hist(:,counter) = W;
        temp1 = ext_rosenbrock_grad(W,lambda);
        p = -H*temp1; % the direction for the current point
        Wc = W; % store the current point W
        %%%%%%%%%%%% Wolfe
        alpha = a0;
        alpha_L = 0;
        alpha_U = realmax;
        while true % Wolfe line search criterion
            Wp = W + alpha*p;
            if ext_rosenbrock_val(Wp, lambda) > ext_rosenbrock_val(W, lambda) +c1*alpha*p'*ext_rosenbrock_grad(W, lambda);
                alpha_U = alpha;
            else
                if p'*ext_rosenbrock_grad(Wp, lambda) < c2*p'*ext_rosenbrock_grad(W, lambda)
                    alpha_L = alpha;
                    else
                        break
                end
            end
            if alpha_U < realmax
                alpha = (alpha_L + alpha_U)/2;
            else
                alpha = 2*alpha_L;
            end

            if alpha<amin
                alpha = amin;
                Wp = W+alpha*p;
                if ext_rosenbrock_val(Wp, lambda) <= ext_rosenbrock_val(W, lambda)
                    break;
                else
                    error('The minimum step size does not produce a descent step. Consider other strategies.');
                end
            end
        end
        %%%%%%%%%%%
        W = W + alpha*p; % find the next point
        s = W - Wc;
        temp2 = ext_rosenbrock_grad(W, lambda);
        y = temp2 - temp1;
        if s'*y >= e_skip*norm(s)*norm(y)
            rho = 1/(y'*s);
            H = (I-rho*s*y')*H*(I-rho*y*s')+rho*(s*s');
        end
        Gap = norm(temp2);
    end
    num_iterations_BFGS = counter
    fw_bfgs = W
    fv_bfgs = ext_rosenbrock_val(W, lambda)
    end

function [y] = ext_rosenbrock_val(x, lambda)
    n = length(x);
    y = 0;
    for i = 1:(n/2)
        x2i_minus_1 = x(2*i - 1);
        x2i = x(2*i);
        term = lambda * (x2i - x2i_minus_1^2)^2 + (1 - x2i_minus_1)^2;
        y = y + term; % Sum up the terms
    end
    end

function y = ext_rosenbrock_grad(x, lambda)
    n = length(x);
    y = zeros(n, 1); % Initialize the gradient vector
    for i = 1:(n/2)
        x2i_minus_1 = x(2*i - 1); 
        x2i = x(2*i); 
        % Compute the derivative of the ith term wrt x2i-1 and x2i
        y(2*i - 1) = lambda * 2 * (x2i - x2i_minus_1^2) * (-2 * x2i_minus_1) - 2 * (1 - x2i_minus_1);
        y(2*i) = lambda * 2 * (x2i - x2i_minus_1^2);
    end
end








