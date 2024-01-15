% stuID1 = A0239429U;
% stuName1 = Tay Xinyu, Zandra;
% stuID2 = A0229830A;
% stuName2 = Lucas Wee Song Wen;

function [O] = HW4_Template(~)

[MAX_utility, MIN_utility, AVG_utility] = Problem1();

[U] = Problem2();

end

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% PROBLEM 1
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

function[MAX_utility, MIN_utility, AVG_utility] = Problem1()
rng(1234);
r1 = 1;                     % reward of getting the sheep
r2 = -1;                    % "reward" of hitting the rock
r0 =-0.04;                  % "reward" of being in each regular state
rho = 0.99;                  % discount factor
RowMax = 5;                 % total number of rows in the map matrix (ref Lect 10 slide 9)
ColMax = 5;                 % total number of columns in the map matrix
TerminateState = [1 1;
                  4 5;
                  1 5]; % set of termination state (each row represents a coordinate where termination occurs
                        % dies or gets sheep
BlockState = [3 1;
              3 3];         % coordinates of the lake
S0 = [5,1];                 % initial starting state
p  = 0.7;                   % prob. of moving along the intended direction
pL = 0.1;                   % prob. of moving along the left 90 degree of the intended direction
N = 10000;                  % total number of periods
TotalReward = zeros(N,1);

%%%%%%%%%%%% Main Program
sheepState = [1, 5];
rockState = [1 1;
             4 5];

tic
for n = 1:1:N
    s = S0;  % initialize the game
    Count = 0; % total number of steps to end the game
    TotalReward(n) = r0;
    while ismember(s,TerminateState,'rows')==0 && Count < 1000 % is state s a row in the terminateState 
        Count = Count + 1;
        [Snext] = OutcomeofaGivenPolicy(s,p,pL,RowMax,ColMax,BlockState); % function that outputs Snext, which is the next state
        if isequal(Snext,sheepState)==1 % check if it's a sheep state
           TotalReward(n) = TotalReward(n) + rho^Count*r1; % accrue cost r1 associated with sheep state
        else
           % if any(ismember(Snext, rockState, 'rows'))==1  % check if it's a rock state
           if ismember(Snext, rockState, 'rows')
              TotalReward(n) = TotalReward(n) + rho^Count*r2; 
           else
              TotalReward(n) = TotalReward(n) + rho^Count*r0;
           end
        end
        s = Snext;
    end
end
toc

%%%%%%%%%%%% Output, plot
MAX_utility = max(TotalReward)
MIN_utility = min(TotalReward)
AVG_utility = mean(TotalReward)

figure
h3 = histogram(TotalReward),%axis([0 xhat 0 8500])
get(gca, 'XTick');
set(gca, 'FontSize', 15, 'FontName','Times New Roman')
get(gca, 'YTick');
set(gca, 'FontSize', 15, 'FontName','Times New Roman')
ylabel('Frequency','Interpreter','latex','FontSize',30),
xlabel('Total Reward','Interpreter','latex','FontSize',30),
title(['Histogram'],'Interpreter','latex','FontSize',20)

end

function[Snext] = OutcomeofaGivenPolicy(s,p,pL,RowMax,ColMax,BlockState)
% s is the current state
% Snext is the state in the next period 
Snext = s;

%%%%%%%%%%% This is a given policy%%%%%%%%%%%
UpState = [4 1;2 2;3 2;4 2;5 2;5 3;2 4;3 4;4 4;2 5];
DownState = [4 3];
RightState = [1 2;1 3;1 4;2 1;2 3;5 1];
LeftState = [3 5;5 4;5 5];
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

R = rand; % this is a standard uniform random number (0, 1)
% determine whether we are gg move up (P = 0.8) or L or R (P = 0.1)

if isempty(LeftState)~=1
   if ismember(s,LeftState,'rows')==1 % go left //or %isequal(s,[1,1])==1 
      if R<p
          Snext(2) = max(1,Snext(2)-1);  % move left 
      elseif R<p+pL
          Snext(1) = min(RowMax,Snext(1)+1); % move down
      elseif R< (p+(pL*2))
          Snext(1) = max(1,Snext(1)-1); % move up
      else
          Snext(2) = min(ColMax, Snext(2)+1); % move right
      end
   end
end

if isempty(RightState)~=1
   if ismember(s,RightState,'rows')==1 % go left //or %isequal(s,[1,1])==1 
      if R<p
          Snext(2) = min(ColMax, Snext(2)+1); % go right
      elseif R<p+pL
          Snext(1) = min(RowMax,Snext(1)+1); % move down
      elseif R< (p+(pL*2))
          Snext(1) = max(1,Snext(1)-1); % move up
      else
          Snext(2) = max(1,Snext(2)-1);  % go left
      end
   end
end

if isempty(UpState)~=1
   if ismember(s,UpState,'rows')==1 % go up
      if R<p
          Snext(1) = max(1,Snext(1)-1); % up
      elseif R<p+pL
          Snext(2) = max(1,Snext(2)-1);  % go left
      elseif R< (p+(pL*2))
          Snext(2) = min(ColMax, Snext(2)+1); % right
      else
          Snext(1) = min(RowMax,Snext(1)+1); % move down
      end
   end
end

if isempty(DownState)~=1
   if ismember(s,DownState,'rows')==1 % go down
      if R<p
         Snext(1) = min(RowMax,Snext(1)+1);   % go down
      elseif R<p+pL
            Snext(2) = max(1, Snext(2)-1); % go left
      elseif R< (p+(pL*2))
          Snext(2) = min(ColMax, Snext(2)+1);  % go right
      else
          Snext(1) = max(1, Snext(1)-1); % go up
      end
   end
end

if ismember(Snext, BlockState, 'rows')
   Snext = s; 
end
end

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% PROBLEM 2
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

function[U] = Problem2()
%%%%%% Input parameters 
rng(125);                  % set the seed for the random number generator. DO NOT Remove this line
r1 = 1;                     % reward of getting the sheep
r2 = -1;                    % "reward" of hitting the rock
r0 = -0.04;                 % "reward" of being in each regular state
rho = 0.99;                    % discount factor      
eps0 = 10^(-13);

%%%%%%%%%%%% Main Program
U0 = rand(5,1);
d = 1; % diff in 2 vectors in 2 adjacent iterations
Count = 1;
UH = zeros(5,1000);
UH(:,1) = U0;
tic
while d>eps0
    U_up = zeros(5,1);
    U_up(1) = 0.7*U0(2)+0.3*U0(1);
    U_up(2) = 0.8*U0(2)+0.1*U0(3)+0.1*U0(1);
    U_up(3) = 0.1*U0(2)+0.1*U0(3)+0.1*U0(4)+0.7*r2;
    U_up(4) = 0.7*r1+0.1*U0(4)+0.1*U0(3)+0.1*U0(5);
    U_up(5) = 0.7*U0(4)+0.3*U0(5);
    
    U_Down = zeros(5,1);
    U_Down(1) = 0.9*U0(1)+0.1*U0(2);
    U_Down(2) = 0.7*U0(1)+0.1*U0(3)+0.2*U0(2);
    U_Down(3) = 0.7*U0(3)+0.1*U0(2)+0.1*U0(4)+0.1*r2;
    U_Down(4) = 0.7*U0(5)+0.1*U0(4)+0.1*U0(3)+0.1*r1;
    U_Down(5) = 0.9*U0(5)+0.1*U0(4);
    
    U_Left = zeros(5,1);
    U_Left(1) = 0.9*U0(1)+0.1*U0(2);
    U_Left(2) = 0.1*U0(3)+0.8*U0(2)+0.1*U0(1);
    U_Left(3) = 0.1*U0(3)+0.1*U0(4)+0.7*U0(2)+0.1*r2;
    U_Left(4) = 0.1*U0(5)+0.1*U0(4)+0.7*U0(3)+0.1*r1;
    U_Left(5) = 0.9*U0(5)+0.1*U0(4);
    
    U_Right = zeros(5,1);
    U_Right(1) = 0.1*U0(2)+0.9*U0(1);
    U_Right(2) = 0.1*U0(1)+0.7*U0(3)+0.2*U0(2);
    U_Right(3) = 0.1*U0(3)+0.1*U0(2)+0.7*U0(4)+0.1*r2;
    U_Right(4) = 0.7*U0(4)+0.1*U0(5)+0.1*U0(3)+0.1*r1;
    U_Right(5) = 0.9*U0(5)+0.1*U0(4);
    
    U = zeros(5,1);
    for i = 1:1:5
        U(i) = r0+rho*max([U_up(i),U_Down(i),U_Left(i),U_Right(i)]); % contraction mapping in lec 10 slide 13
    end
    d = max(abs(U-U0)); % check diff in distance between original vector and newly computed vector
    U0 = U;
    Count = Count+1;

end
toc

U0(1:5)
end
